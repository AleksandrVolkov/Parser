package test_pars;

import com.java.sql.repos.domain.classess.Monitor;
import com.java.sql.repos.domain.classess.PC;
import com.java.sql.repos.domain.classess.Printer;
import com.java.sql.repos.domain.product.Product;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.security.core.parameters.P;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public Document getPage(String url) throws IOException, URISyntaxException {
//        Connection.Response response = Jsoup.connect(url).timeout(45000)
//                .method(Connection.Method.GET)
//                .ignoreContentType(true)
//                .userAgent("Mozilla/5.0 (Windows NT 6.3; rv:40.0) Gecko/20100101 Firefox/40.0")
//                .followRedirects(true)
//                .execute();
//        return (Document) response;
        try {
            return Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.117 YaBrowser/20.2.0.1043 Yowser/2.5 Safari/537.36") //
//                .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36") //
//                .referrer("www.mmbang.com")
                    .referrer("http://www.google.com")
                    .get();
        } catch (Exception e) {
            System.out.println("Перейдите по ссылке и пройдите капчу -> " + url);
            Process process = null;
            RemoteWebDriver driver = null;
            try {
                process = new ProcessBuilder("C:\\Users\\sashu\\Desktop\\webSQL-master\\src\\main\\resources\\chromedriver.exe").start();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\sashu\\Desktop\\webSQL-master\\src\\main\\resources\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            try {
                driver = new RemoteWebDriver(new URL("http://127.0.0.1:9515"), options);
            } catch (MalformedURLException es) {
                es.printStackTrace();
            }

//            System.setProperty("webdriver.chrome.driver", "C:\\Users\\sashu\\Desktop\\webSQL-master\\src\\main\\resources\\chromedriver.exe");
//            ChromeDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get(url);
            WebElement textBox = driver.findElementById("captcha_limit");
            textBox.sendKeys("В");
            WebElement button = driver.findElementByClassName("request-limit-page__submit");
            button.click();
            driver.close();
            process.destroy();

//            return null;
            return getPage(url);
        }


//        return Jsoup.connect(url)
//                .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.117 YaBrowser/20.2.0.1043 Yowser/2.5 Safari/537.36") //
////                .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36") //
////                .referrer("www.mmbang.com")
//                .referrer("http://www.google.com")
//                .get();
    }

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {

//        String text = "Егор Алла Анна";
//        Pattern pattern = Pattern.compile("А.+?а");
//
//        Matcher matcher = pattern.matcher(text);
//        while (matcher.find()) {
//            int start=matcher.start();
//            int end=matcher.end();
//            System.out.println("Найдено совпадение " + text.substring(start,end) + " с "+ start + " по " + (end-1) + " позицию");
//        }
//        System.out.println(matcher.replaceFirst("Ира"));
//        System.out.println(matcher.replaceAll("Ольга"));
//        System.out.println(text);
//
//        String text = "\tDIMM, DDR4 4096 Мб 2666 МГц";
//        Pattern pattern = Pattern.compile("\\d+\\s+Мб");
//        Matcher matcher = pattern.matcher(text);
//        matcher.find();
//        String sd = text.substring(matcher.start(), matcher.end() - 6) + " ГБ";
//
//        System.out.println(text.substring(matcher.start(), matcher.end() - 6));
//        while (matcher.find()) {
//            int start=matcher.start();
//            int end=matcher.end();
//            System.out.println(text.substring(start,end) );
//        }
//        String sd = text.substring(matcher.start(), matcher.end()-1);

//        List<ShortProduct> l1 = citilink(1);
//        String sd = "jack 3.5 mm х5, USB Type-C, USB 2.0 x4, USB 3.0 x3";
//
//        for (String s : sd.split(",")) {
//            if (s.contains("jack"))
//                System.out.println(s.substring(s.length() - 1));
//            if (s.contains("USB 2.0"))
//                System.out.println(s.substring(s.length() - 1));
//            if (s.contains("USB 3.0"))
//                System.out.println(s.substring(s.length() - 1));
//            if (s.contains("USB Type-C"))
//                System.out.println(s.substring(s.length() - 1));
//
//        }

        int i = 1;
        Parser p = new Parser();
        String url_citilinc = "https://www.citilink.ru/catalog/computers_and_notebooks/computers/?available=1&status=55395790&p=" + String.valueOf(i);
        String url_dns = "https://www.dns-shop.ru/catalog/17a8932c16404e77/sistemnye-bloki/?p=" + String.valueOf(i) + "&order=1&groupBy=none&stock=2";

//        String text = "процессор: Intel Core i7 7700; частота процессора: 3.6 ГГц (4.2 ГГц, в режиме Turbo); оперативная память: DIMM, DDR4 16384 Мб 2133 МГц; видеокарта: NVIDIA GeForce GTX 1070 — 8192 Мб; интегрированная графика: Intel HD Graphics 630; HDD: 1000 Гб, 7200 об/мин, SATA III; SSD: 240Гб";
////        String text = "\tDIMM, DDR4 4096 Мб 2666 МГц";
//        String[] split = text.split("; ");
//        String model = "";
//        String freq = "";
//        String ram_size = "";
//        String ram_model = "";
//        String ram_ferq = "";
//        String gpu_size = "";
//        String gpu_model = "";
//        String integr_gpu = "";
//        String hdd_data = "";
//        String ssd_data = "";
//        for (String str : split) {
//            if (str.contains("процессор: ")) {
//                model = str.replace("процессор: ", "");
//            }
//            if (str.contains("частота процессора: ")) {
//                freq = str.replace("частота процессора: ", "").substring(0, 6);
//            }
//            if (str.contains("оперативная память: ")) {
//                String text1 = str.replace("оперативная память: ", "");
//                Pattern pattern = Pattern.compile("\\d+\\s+Мб");
//                Matcher matcher = pattern.matcher(text1);
//                matcher.find();
//                ram_size = text1.substring(matcher.start(), matcher.end() - 6) + " ГБ";
//                ram_model = text1.substring(0, matcher.start());
//                ram_ferq = text1.substring(matcher.end());
//
//            }
//            if (str.contains("видеокарта: ")) {
//                String text1 = str.replace("видеокарта: ", "");
//                Pattern pattern = Pattern.compile("\\d+\\s+Мб");
//                Matcher matcher = pattern.matcher(text1);
//                matcher.find();
//                gpu_size = text1.substring(matcher.start(), matcher.end() - 6) + " ГБ";
//                gpu_model = text1.substring(0, matcher.start() - 3);
//
//            }
//            if (str.contains("интегрированная графика: ")) {
//                integr_gpu = str.replace("интегрированная графика: ", "");
//
//            }
//            if (str.contains("HDD: ")) {
//                hdd_data = str.replace("HDD: ", "").split(",")[0];
//
//            }
//            if (str.contains("SSD: ")) {
//                ssd_data = str.replace("SSD: ", "");
//            }
//        }
//
//        Pattern pattern = Pattern.compile("\\d+\\s+Мб");
//        Matcher matcher = pattern.matcher(text);
//        matcher.find();
//        String sd = text.substring(matcher.start(), matcher.end() - 6) + " ГБ";
        List<Product> l1 = p.DNS_PC(url_dns, PC.class);
//        List<Product> l2 = p.citilink_PC(url_citilinc,PC.class);

    }

    // придумать как передавать нужный клаас для парсинга, можно передавать класс, а потом в трёх if сравнивать
    public List<Product> DNS_PC(String url, Class clazz) throws IOException, URISyntaxException {
        Document page = getPage(url);
        Element element = page.select("div[class=products-list__content]").first();
        Elements els = element.select("div[class=n-catalog-product__main]");
        List<Product> productList = new ArrayList<>();
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
            if (name.contains("&nbsp;"))
                name = name.replace("&nbsp;", " ");
            String linkOnFullDescription = "https://www.dns-shop.ru" + el.select("div[class=product-info__title-link]").select("a").first().attr("href") + "characteristics/";

            String shortDescription = el.select("span[class=product-info__title-description]").first().text();

            Document page1 = getPage(linkOnFullDescription);
            Element content = page1.selectFirst("div[class=price-item ec-price-item]");
            String price = content.selectFirst("div[class=col-header col-order]").selectFirst("div[class=price_g]").selectFirst("span").text();

            PC product = new PC("pc", "dns", shortImg, name, shortDescription, linkOnFullDescription, new BigDecimal(Integer.parseInt(price.replace(" ", ""))));
// паршу полное описание продукта
            if (clazz == PC.class)
                setPC_dns(content, product);
            if (clazz == Monitor.class)
                setPC_dns(content, product);
            if (clazz == Printer.class)
                setPC_dns(content, product);

            productList.add(product);

            System.out.print(count++);
            if (product != null) System.out.printf(" true\n");
        }
        int ss = 9;

        return productList;
    }

    public List<Product> citilink_PC(String url, Class clazz) throws IOException, InterruptedException, URISyntaxException {
        Document page = getPage(url);
        Element element = page.select("div[class=block_data__gtm-js block_data__pageevents-js listing_block_data__pageevents-js]").first();
        Elements els = element.select("div[class=js--subcategory-product-item subcategory-product-item product_data__gtm-js  product_data__pageevents-js ddl_product]");
        List<Product> productList = new ArrayList<>();

        int count = 1;
        for (Element el : els) {
            String shortImg = "";
            try {
                String shortImg1 = el.select("div[class=wrap-img]").first().selectFirst("img").attr("src");
                String shortImg2 = el.select("div[class=wrap-img]").first().selectFirst("img").attr("data-src");
                shortImg = shortImg1.equals("") ? shortImg2 : shortImg1;
            } catch (NullPointerException e) {
            }

            String name = el.select("a[class=link_gtm-js link_pageevents-js ddl_product_link]").first().attr("title");
            if (name.contains("&nbsp;"))
                name = name.replace("&nbsp;", " ");

            String linkOnFullDescription = el.select("a[class=link_gtm-js link_pageevents-js ddl_product_link]").attr("href");
            String price = "нет в наличии";
            try {
                price = el.select("span[class=subcategory-product-item__price subcategory-product-item__price_standart]").first()
                        .selectFirst("ins[class=subcategory-product-item__price-num]").text();
            } catch (NullPointerException e) {
                System.out.println(e);
            }
            Document page1 = getPage(linkOnFullDescription);
            String shortDescription = page1.select("p[class=short_description]").first().text();

            PC product = new PC("pc", "citilink", shortImg, name, shortDescription, linkOnFullDescription, new BigDecimal(Integer.parseInt(price.replace(" ", ""))));
            String[] split = shortDescription.split("; ");
//            for (String str : split) {
//                if (str.contains("процессор: "))
//                    product.setCpu_model(str.replace("процессор: ", ""));
//                if (str.contains("частота процессора: "))
//                    product.setCpu_frequency(str.replace("частота процессора: ", "").substring(0, 6));
//                if (str.contains("оперативная память: ")) {
//                    String text1 = str.replace("оперативная память: ", "");
//                    Pattern pattern = Pattern.compile("\\d+\\s+Мб");
//                    Matcher matcher = pattern.matcher(text1);
//                    if (matcher.find()) {
//                        product.setRam_model(text1.substring(0, matcher.start()));
//                        product.setRam_size(text1.substring(matcher.start(), matcher.end() - 6) + " ГБ");
//                        product.setRam_frequency(text1.substring(matcher.end()));
//                    } else
//                        product.setRam_model(text1);
//                }
//                if (str.contains("видеокарта: ")) {
//                    String text1 = str.replace("видеокарта: ", "");
//                    Pattern pattern = Pattern.compile("\\d+\\s+Мб");
//                    Matcher matcher = pattern.matcher(text1);
//                    if (matcher.find()) {
//                        product.setGpu_discrete_model(text1.substring(0, matcher.start() - 3));
//                        product.setGpu_discrete_size(text1.substring(matcher.start(), matcher.end() - 6) + " ГБ");
//                    } else
//                        product.setGpu_discrete_model(text1);
//                }
//                if (str.contains("интегрированная графика: "))
//                    product.setGpu_integrated_model(str.replace("интегрированная графика: ", ""));
//                if (str.contains("HDD: "))
//                    product.setHdd_data(str.replace("HDD: ", "").split(",")[0]);
//                if (str.contains("SSD: "))
//                    product.setSsd_data(str.replace("SSD: ", ""));
//            }
            if (clazz == PC.class)
                setPC_citilink(product, split);
            if (clazz == Monitor.class)
                setPC_citilink(product, split);
            if (clazz == Printer.class)
                setPC_citilink(product, split);


            productList.add(product);
            System.out.print(count++);
            if (product != null) System.out.printf(" true\n");
        }
        return productList;
    }

    public static PC setPC_citilink(PC product, String[] split) {
        for (String str : split) {
            if (str.contains("процессор: "))
                product.setCpu_model(str.replace("процессор: ", ""));
            if (str.contains("частота процессора: "))
                product.setCpu_frequency(str.replace("частота процессора: ", "").substring(0, 6));
            if (str.contains("оперативная память: ")) {
                String text1 = str.replace("оперативная память: ", "");
                Pattern pattern = Pattern.compile("\\d+\\s+Мб");
                Matcher matcher = pattern.matcher(text1);
                if (matcher.find()) {
                    product.setRam_model(text1.substring(0, matcher.start()));
                    product.setRam_size(text1.substring(matcher.start(), matcher.end() - 6) + " ГБ");
                    product.setRam_frequency(text1.substring(matcher.end()));
                } else
                    product.setRam_model(text1);
            }
            if (str.contains("видеокарта: ")) {
                String text1 = str.replace("видеокарта: ", "");
                Pattern pattern = Pattern.compile("\\d+\\s+Мб");
                Matcher matcher = pattern.matcher(text1);
                if (matcher.find()) {
                    product.setGpu_discrete_model(text1.substring(0, matcher.start() - 3));
                    product.setGpu_discrete_size(text1.substring(matcher.start(), matcher.end() - 6) + " ГБ");
                } else
                    product.setGpu_discrete_model(text1);
            }
            if (str.contains("интегрированная графика: "))
                product.setGpu_integrated_model(str.replace("интегрированная графика: ", ""));
            if (str.contains("HDD: "))
                product.setHdd_data(str.replace("HDD: ", "").split(",")[0]);
            if (str.contains("SSD: "))
                product.setSsd_data(str.replace("SSD: ", ""));
        }
        return product;
    }

    public static PC setPC_dns(Element content, PC product) {
        Elements tableContent = content.selectFirst("div[id=characteristics]").select("tr");
        for (int i = 0; i < tableContent.size(); i++) {
            Element tr = tableContent.get(i);
            if (tr.attr("class").equals("extended-characteristic hidden")) continue;
//                Map<String, String> tableContentTR = new HashMap<>();
            if (tr.selectFirst("td").attr("class").equals("table-part")) {
//                    String mainTh = tr.selectFirst("td").text();
                i++;
                String gpu_model = null;
                String gpu_chip_type = null;
                for (int j = i; j < tableContent.size(); i++) {
                    if (tableContent.get(i).selectFirst("tr").attr("class").equals("extended-characteristic hidden"))
                        continue;
                    String th = tableContent.get(i).selectFirst("tr").selectFirst("span").text();
                    String td = tableContent.get(i).selectFirst("tr").select("td").get(1).text();

                    if (th.contains("Модель процессора"))
                        product.setCpu_model(td);
                    if (th.contains("Частота процессора"))
                        product.setCpu_frequency(td);
                    if (th.contains("Тип оперативной памяти"))
                        product.setRam_model(td);
                    if (th.contains("Размер оперативной памяти"))
                        product.setRam_size(td);


                    if (th.contains("Производитель видеочипа"))
                        gpu_chip_type = td;
                    if (th.contains("Модель дискретной видеокарты"))
                        gpu_model = td;
                    if (th.contains("Объем видеопамяти"))
                        product.setGpu_discrete_size(td.contains("МБ") ? td.substring(0, td.length() - 6) : null);
                    if (th.contains("Модель интегрированной видеокарты"))
                        product.setGpu_integrated_model(td);
                    if (th.contains("Суммарный объем жестких дисков (HDD)"))
                        product.setHdd_data(td.contains("нет") ? null : td);
                    if (th.contains("Объем твердотельного накопителя (SSD)"))
                        product.setSsd_data(td.contains("нет") ? null : td);

//                        tableContentTR.put(th, td);
                    if (i == tableContent.size() - 1) break;
                    if (tableContent.get(i + 1).selectFirst("td").attr("class").equals("table-part")
                            || tableContent.get(i + 1).attr("class").equals("extended-characteristic hidden"))
                        break;
                }
                if (product.getGpu_discrete_model() == null)
                    product.setGpu_discrete_model(gpu_chip_type == null || gpu_model == null || gpu_chip_type.equals("нет") || gpu_model.equals("нет") ? null : gpu_chip_type + " " + gpu_model);
//                    fullProductDescription.put(mainTh, tableContentTR);
            }
        }
        return product;

    }
}
