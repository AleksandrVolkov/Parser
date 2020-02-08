package test_pars;

import com.java.sql.repos.domain.classess.PC;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser1 {
    private static Document getPage(String url) throws IOException {
//        Connection.Response response = Jsoup.connect(url).timeout(45000)
//                .method(Connection.Method.GET)
//                .ignoreContentType(true)
//                .userAgent("Mozilla/5.0 (Windows NT 6.3; rv:40.0) Gecko/20100101 Firefox/40.0")
//                .followRedirects(true)
//                .execute();
        return Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36") //
                .referrer("www.mmbang.com")
                .get();
    }

//    public static void main(String[] args) throws IOException {
//        List<ShortProduct> l1 = citilink();
//        List<ShortProduct> l2 = DNS();
//
//    }

    public static List DNS() throws IOException {
        String url = "https://www.dns-shop.ru/catalog/17a8932c16404e77/sistemnye-bloki/?p=9&order=1&groupBy=none&stock=1";
        Document page = getPage(url);
        Element element = page.select("div[class=products-list__content]").first();
        Elements els = element.select("div[class=n-catalog-product__main]");
        List<ShortProduct> productList = new ArrayList<>();
        int count = 1;
        for (Element el : els) {
// паршу основнную страницу где много компов
            String shortImg = "";
            try {
                String shortImg1 = el.select("a[class=show-popover ec-price-item-link]").first().selectFirst("img").attr("src");
                String shortImg2 = el.select("a[class=show-popover ec-price-item-link]").first().selectFirst("img").attr("data-src");
                shortImg = shortImg1.equals("") ? shortImg2 : shortImg1;
            } catch (NullPointerException e) {
            }

            String name = el.select("div[class=product-info__title-link]").select("a").first().text();
            String linkOnFullDescription = "https://www.dns-shop.ru" + el.select("div[class=product-info__title-link]").select("a").first().attr("href");
            String shortDescription = el.select("span[class=product-info__title-description]").first().text();


// перехожу на ссылку текущего компа и паршу уже эту страницу
            Document page1 = getPage(linkOnFullDescription);
            Map<String, Map<String, String>> fullProductDescription = new HashMap<>();
            Element content = page1.selectFirst("div[class=price-item ec-price-item]");
            String price = content.selectFirst("div[class=col-header col-order]").selectFirst("div[class=price_g]").selectFirst("span").text();
// паршу картинки и записываю в лист
            Elements images = content.select("div[class=image-slider]").first().select("img");
            List<String> imagesList = new ArrayList<>();
            for (Element im : images) {
                String img = im.attr("src") != "" ? im.attr("src") : im.attr("data-src");
                imagesList.add(img);
            }

// паршу полное описание продукта
            Elements tableContent = content.selectFirst("div[id=main-characteristics]").select("tr");
            for (int i = 0; i < tableContent.size(); i++) {
                Element tr = tableContent.get(i);
                if (tr.attr("class").equals("extended-characteristic hidden")) continue;
                Map<String, String> tableContentTR = new HashMap<>();
                if (tr.selectFirst("td").attr("class").equals("table-part")) {
                    String mainTh = tr.selectFirst("td").text();
                    i++;
                    for (int j = i; j < tableContent.size(); i++) {
                        if (tableContent.get(i).selectFirst("tr").attr("class").equals("extended-characteristic hidden"))
                            continue;
                        String th = tableContent.get(i).selectFirst("tr").selectFirst("span").text();
                        String td = tableContent.get(i).selectFirst("tr").select("td").get(1).text();
                        tableContentTR.put(th, td);
                        if (i == tableContent.size() - 1) break;
                        if (tableContent.get(i + 1).selectFirst("td").attr("class").equals("table-part")
                                || tableContent.get(i + 1).attr("class").equals("extended-characteristic hidden"))
                            break;
                    }
                    fullProductDescription.put(mainTh, tableContentTR);
                }
            }
//            ShortProduct sp = new ShortProduct(shortImg, name, linkOnFullDescription, shortDescription, price, new PC());
//            productList.add(sp);
//
//            System.out.print(count++);
//            if (sp != null) System.out.printf(" true\n");
        }
        int ss = 9;

        return productList;
    }

    public static List citilink() throws IOException {
        String url = "https://www.citilink.ru/catalog/computers_and_notebooks/computers/?available=1&status=55395790&p=23";
        Document page = getPage(url);

        Element element = page.select("div[class=block_data__gtm-js block_data__pageevents-js listing_block_data__pageevents-js]").first();
        Elements els = element.select("div[class=js--subcategory-product-item subcategory-product-item product_data__gtm-js  product_data__pageevents-js ddl_product]");
        List<ShortProduct> productList = new ArrayList<>();

        int count = 1;
        for (Element el : els) {

// паршу основнную страницу где много компов
            String shortImg = "";
            try {
                String shortImg1 = el.select("div[class=wrap-img]").first().selectFirst("img").attr("src");
                String shortImg2 = el.select("div[class=wrap-img]").first().selectFirst("img").attr("data-src");
                shortImg = shortImg1.equals("") ? shortImg2 : shortImg1;
            } catch (NullPointerException e) {
            }

            String name = el.select("a[class=link_gtm-js link_pageevents-js ddl_product_link]").first().attr("title");
            String linkOnFullDescription = el.select("a[class=link_gtm-js link_pageevents-js ddl_product_link]").attr("href");
            String shortDescription = el.select("p[class=short_description]").first().text();
            String price = el.select("span[class=subcategory-product-item__price subcategory-product-item__price_standart]").first()
                    .selectFirst("ins[class=subcategory-product-item__price-num]").text();


// перехожу на ссылку текущего компа и паршу уже эту страницу
            Document page1 = getPage(linkOnFullDescription);
            List<String> imageList = new ArrayList<>();
            Map<String, Map<String, String>> fullProductDescription = new HashMap<>();
            Element content = page1.selectFirst("div[class=specification_view product_view]");

// паршу картинки и записываю в лист
            Element imgContent = content.selectFirst("div[class=image_gallery]");
            imageList.add(content.selectFirst("div[class=full_content]").selectFirst("img").attr("src"));
            Elements images = imgContent.select("div[class=preview_list]").select("li[class=photo_carousel__js]");
            for (Element im1 : images) {
                imageList.add(im1.selectFirst("img").attr("src"));
            }

// паршу полное описание продукта
            Element productFeatures = content.selectFirst("table[class=product_features]");
            Elements elTable = productFeatures.select("tr");
            for (int i = 0; i < elTable.size(); i++) {
                Map<String, String> elemTR = new HashMap<>();
                Element tr = elTable.get(i);
                if (tr.attr("class").equals("header_row")) {
                    String mainTh = elTable.get(i).selectFirst("th").text();
                    i++;
                    for (int j = i; j < elTable.size(); i++) {
                        String th = elTable.get(i).selectFirst("th").text();
                        String td = elTable.get(i).selectFirst("td").text();
                        elemTR.put(th, td);
                        if (i == elTable.size() - 1) break;
                        if (elTable.get(i + 1).attr("class").equals("header_row")) break;
                    }
                    fullProductDescription.put(mainTh, elemTR);
                }
            }
//            ShortProduct sp = new ShortProduct(shortImg, name, linkOnFullDescription, shortDescription, price, new PC());
////            productList.add(sp);
////
////            System.out.print(count++);
////            if (sp != null) System.out.printf(" true\n");
        }
        int ss = 9;

        return productList;
    }
}
