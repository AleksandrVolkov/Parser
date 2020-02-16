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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.*;
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
//            System.out.println("Перейдите по ссылке и пройдите капчу -> " + url);
//            Process process = null;
//            RemoteWebDriver driver = null;
//            try {
//                process = new ProcessBuilder("C:\\Users\\sashu\\Desktop\\webSQL-master\\src\\main\\resources\\chromedriver.exe").start();
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
//            System.setProperty("webdriver.chrome.driver", "C:\\Users\\sashu\\Desktop\\webSQL-master\\src\\main\\resources\\chromedriver.exe");
//            ChromeOptions options = new ChromeOptions();
//            try {
//                driver = new RemoteWebDriver(new URL("http://127.0.0.1:9515"), options);
//            } catch (MalformedURLException es) {
//                es.printStackTrace();
//            }

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\sashu\\Desktop\\webSQL-master\\src\\main\\resources\\chromedriver.exe");
//            ChromeOptions options = new ChromeOptions();
//            RemoteWebDriver driver =  driver = new RemoteWebDriver(new URL("http://127.0.0.1:9515"), options);
            ChromeDriver driver = new ChromeDriver();
//            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//            driver.
//            options.
            driver.get(url);
            try {
                WebElement textBox = driver.findElementById("captcha_limit");
                textBox.sendKeys("В");
                WebElement button = driver.findElementByClassName("request-limit-page__submit");
                button.click();
                driver.close();
            } catch (Exception e1) {
                driver.close();
                e.printStackTrace();
            }


//            assert process != null;
//            process.destroy();

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
//        String str = " максимальная скорость печати (ЧБ) 18стр/мин";
//        String str1 = " , максимальная скорость печати (ЧБ) до 14.5 стр/мин,";
//        String text1 = str.replace("максимальная скорость печати ", "");
//        Pattern pattern = Pattern.compile("\\d+.?\\d*\\s*стр/мин");
//        Matcher matcher = pattern.matcher(text1);
//        if (matcher.find())
//            text1 = text1.substring(matcher.start(), matcher.end()-7);
        String sda = "m00176950";
        boolean sdwe = sda.matches("^\\d+$");
        ;

        int i = 5;
        Parser p = new Parser();
        String url_citilinc_pc = "https://www.citilink.ru/catalog/computers_and_notebooks/computers/?available=1&status=55395790&p=" + String.valueOf(i);
//        String url_citilinc_monitor = "https://www.citilink.ru/catalog/computers_and_notebooks/monitors/?available=1&status=55395790&p=" + String.valueOf(i);
        String url_citilinc_printer_lazer = "https://www.citilink.ru/catalog/computers_and_notebooks/monitors_and_office/printers/?available=1&status=55395790&p=" + String.valueOf(i);
        String url_citilinc_printer_struya = "https://www.citilink.ru/catalog/computers_and_notebooks/monitors_and_office/ink_printers/?available=1&status=55395790&p=" + String.valueOf(i);
//        String url_dns_pc = "https://www.dns-shop.ru/catalog/17a8932c16404e77/sistemnye-bloki/?p=" + String.valueOf(i) + "&order=1&groupBy=none&stock=2";
//        String url_dns_monitor = "https://www.dns-shop.ru/catalog/17a8943716404e77/monitory/?p=" + String.valueOf(i) + "&order=1&groupBy=none&stock=2&q=%D0%BC%D0%BE%D0%BD%D0%B8%D1%82%D0%BE%D1%80";
        String url_dns_printer_lazer = "https://www.dns-shop.ru/catalog/17a8e00716404e77/lazernye-printery/?p=" + String.valueOf(i) + "&order=1&groupBy=none&stock=2&q=%D0%BF%D1%80%D0%B8%D0%BD%D1%82%D0%B5%D1%80";
        String url_dns_printer_struya = "https://www.dns-shop.ru/catalog/17a8e07216404e77/strujnye-printery/?p=" + String.valueOf(i) + "&order=1&groupBy=none&stock=2&f[nz8]=9hd9&q=%D0%BF%D1%80%D0%B8%D0%BD%D1%82%D0%B5%D1%80%D1%8B";
//
//        String text = "технология печати: струйный, цветной, формат: A4, максимальная скорость печати (ЧБ) до 13 стр/мин, формата А4, USB, RJ-45, Wi-Fi, встроенная СНПЧ, двусторонняя печать";
//        String[] split = text.split(", ");
//        String type = "";
//        String color = "";
//        String format = "";
//        String max_print_speed = "";
//        String connector = "";
//        String CISS = "";
//        String two_sided_printing = "";
//
//
//        for (String str : split) {
//            if (str.contains("технология печати: ")) {
//                type = str.replace("технология печати: ", "");
//            }
//            if (str.contains("цветной") || str.contains("черно-белый")) {
//                color = str.trim();
//            }
//            if (str.contains("формат: ")) {
//                format = str.replace("формат: ", "");
//            }
//            if (str.contains("максимальная скорость печати ")) {
//                max_print_speed = str.replace("максимальная скорость печати ", "");
//
//            }
//            if (str.contains("USB") || str.contains("RJ-45") || str.contains("Wi-Fi") || str.contains("LPT") || str.contains("LPT")) {
//                connector += str.trim() + ", ";
//
//            }
//            if (str.contains("встроенная СНПЧ")) {
//                CISS = "есть";
//            }
//            if (str.contains("двусторонняя печать")) {
//                two_sided_printing = "есть";
//            }
//
//        }
//
//        Pattern pattern = Pattern.compile("\\d+\\s+Мб");
//        Matcher matcher = pattern.matcher(text);
//        matcher.find();
//        String sd = text.substring(matcher.start(), matcher.end() - 6) + " ГБ";
        List<Product> l1 = p.DNS(url_dns_printer_lazer, Printer.class);
//        List<Product> l2 = p.citilink(url_citilinc_printer_lazer, Printer.class);

    }

    // придумать как передавать нужный клаас для парсинга, можно передавать класс, а потом в трёх if сравнивать
    public List<Product> DNS(String url, Class clazz) throws IOException, URISyntaxException {
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
                e.printStackTrace();
            }

            String name = el.select("div[class=product-info__title-link]").select("a").first().text();
            if (name.contains("&nbsp;"))
                name = name.replace("&nbsp;", " ");
            String linkOnFullDescription = "https://www.dns-shop.ru" + el.select("div[class=product-info__title-link]").select("a").first().attr("href") + "characteristics/";

            String shortDescription = el.select("span[class=product-info__title-description]").first().text();

            Document page1 = getPage(linkOnFullDescription);
            Element content = page1.selectFirst("div[class=price-item ec-price-item]");
            String price = content.selectFirst("div[class=col-header col-order]").selectFirst("div[class=price_g]").selectFirst("span").text();

//            PC product = new PC("pc", "dns", shortImg, name, shortDescription, linkOnFullDescription, new BigDecimal(Integer.parseInt(price.replace(" ", ""))));
// паршу полное описание продукта
            if (clazz == PC.class) {
                PC product = new PC(0L, "pc", "dns", shortImg, name, shortDescription, linkOnFullDescription, new BigDecimal(Integer.parseInt(price.replace(" ", ""))));
                setPC_dns(content, product);
                String short_descr = "процессор: " + product.getCpu_model() + "; частота процессора: " + product.getCpu_frequency() + "; оперативная память: " + product.getRam_model() +
                        " " + product.getRam_size() + " " + product.getRam_frequency() + "; видеокарта: " + product.getGpu_discrete_model() + " — " + product.getGpu_discrete_size() +
                        "; интегрированная: " + product.getGpu_integrated_model() + "; HDD: " + product.getHdd_data() + "; SSD: " + product.getSsd_data();
                product.setShort_description(short_descr.replace("null", "нет"));
                product.setProduct_id(Long.parseLong(page1.selectFirst("div[class=price-item-code]").selectFirst("span").text().trim() + "1234"));

                productList.add(product);
            }
            if (clazz == Monitor.class) {
                Monitor product = new Monitor(0L, "monitor", "dns", shortImg, name, shortDescription, linkOnFullDescription, new BigDecimal(Integer.parseInt(price.replace(" ", ""))));
                setMonitor_dns(content, product);
                String short_descr = "экран: " + product.getScreen() + ", частота: " + product.getScreen_frequency() + ", матрица " + product.getMatrix_type() +
                        " с разрешением " + product.getScreen_resolution() + ", отношением сторон " + product.getAspect_ratio() + ", яркостью " + product.getBrightness() +
                        ", временем отклика " + product.getResponse_time() + ", разъем " + product.getConnector();
                product.setShort_description(short_descr.replace("null", "нет"));
                product.setProduct_id(Long.parseLong(page1.selectFirst("div[class=price-item-code]").selectFirst("span").text().trim() + "1234"));

                productList.add(product);
            }
            if (clazz == Printer.class) {
                Printer product = new Printer(0L, "printer", "dns", shortImg, name, shortDescription, linkOnFullDescription, new BigDecimal(Integer.parseInt(price.replace(" ", ""))));
                setPrinter_dns(content, product);
                String short_descr = "технология печати: " + product.getType() + ", " + product.getColor() + ", формат: " + product.getFormat() +
                        ", максимальная скорость печати " + product.getMax_print_speed() + ", " + product.getConnector() + ", встроенная СНПЧ - " + product.getCISS() +
                        ", двусторонняя печать - " + product.getTwo_sided_printing();
                product.setShort_description(short_descr.replace("null", "нет"));
                product.setProduct_id(Long.parseLong(page1.selectFirst("div[class=price-item-code]").selectFirst("span").text().trim() + "1234"));


                productList.add(product);
            }


//            productList.add(product);

            System.out.print(count);
            if (productList.size() == count++) System.out.printf(" true\n");
        }
        int ss = 9;

        return productList;
    }

    public List<Product> citilink(String url, Class clazz) throws IOException, InterruptedException, URISyntaxException {
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
            Element content = page1.selectFirst("div[class=specification_view product_view]");

            String[] split;
            if (clazz == PC.class) {
                PC product = new PC(0L, "pc", "citilink", shortImg, name, shortDescription, linkOnFullDescription, new BigDecimal(Integer.parseInt(price.replace(" ", ""))));
                split = shortDescription.split("; ");
                setPC_citilink(product, split);

                Element productFeatures = content.selectFirst("table[class=product_features]");
                Elements elTable = productFeatures.select("tr");
                boolean flag = false;
                for (int i = 0; i < elTable.size(); i++) {
                    Element tr = elTable.get(i);
                    if (tr.attr("class").equals("header_row")) {
                        String mainTh = elTable.get(i).selectFirst("th").text();

                        i++;
                        if (mainTh.contains("Процессор"))
                            for (int j = i; j < elTable.size(); i++) {
                                String th = elTable.get(i).selectFirst("th").text();
                                String td = elTable.get(i).selectFirst("td").text();
                                if (th.contains("Количество ядер процессора")) {
                                    switch (td) {
                                        case ("двухъядерный"):
                                        case ("2"):
                                            product.setCpu_cores_count(2);
                                            break;
                                        case ("четырехъядерный"):
                                        case ("4"):
                                            product.setCpu_cores_count(4);
                                            break;
                                        case ("шестиядерный"):
                                        case ("6"):
                                            product.setCpu_cores_count(6);
                                            break;
                                        case ("восьмиядерный"):
                                        case ("8"):
                                            product.setCpu_cores_count(8);
                                            break;
                                    }
                                    flag = true;
                                    break;
                                }
                                if (i == elTable.size() - 1) break;
                                if (elTable.get(i + 1).attr("class").equals("header_row")) break;
                            }
                        if (flag) break;
                    }
                }

                String ss = page1.selectFirst("span[class=product_id]").text().trim() + "4321";
                if (ss.matches("^\\d+$")) {
                    product.setProduct_id(Long.parseLong(ss));
                    productList.add(product);
                }

            }
            if (clazz == Monitor.class) {
                Monitor product = new Monitor(0L, "monitor", "citilink", shortImg, name, shortDescription, linkOnFullDescription, new BigDecimal(Integer.parseInt(price.replace(" ", ""))));
                split = shortDescription.split(", ");
                setMonitor_citilink(product, split);
                String ss = page1.selectFirst("span[class=product_id]").text().trim() + "4321";
//                boolean sss = !ss.matches("\\D+\\d+");
                if (ss.matches("^\\d+$")) {
                    product.setProduct_id(Long.parseLong(ss));
                    productList.add(product);
                }
            }
            if (clazz == Printer.class) {
                Printer product = new Printer(0L, "printer", "citilink", shortImg, name, shortDescription, linkOnFullDescription, new BigDecimal(Integer.parseInt(price.replace(" ", ""))));
                split = shortDescription.split(", ");
                setPrinter_citilink(product, split);
                String ss = page1.selectFirst("span[class=product_id]").text().trim() + "4321";
                if (ss.matches("^\\d+$")) {
                    product.setProduct_id(Long.parseLong(ss));
                    productList.add(product);
                }
            }


            System.out.print(count);
            if (productList.size() == count++) System.out.printf(" true\n");
        }
        return productList;
    }

    public static PC setPC_citilink(PC product, String[] split) {
        for (String str : split) {
            if (str.contains("процессор: "))
                product.setCpu_model(str.replace("процессор: ", ""));
            if (str.contains("частота процессора: ")) {
                String str_freq = str.replace("частота процессора: ", "").split(" ")[0];
                product.setCpu_frequency(Double.valueOf(str_freq));
            }
            if (str.contains("оперативная память: ")) {
                String text1 = str.replace("оперативная память: ", "");
                Pattern pattern = Pattern.compile("\\d+\\s+Мб");
                Matcher matcher = pattern.matcher(text1);
                if (matcher.find()) {
                    product.setRam_model(text1.substring(0, matcher.start()));
                    String ramSize = text1.substring(matcher.start(), matcher.end() - 6) + " ГБ";
                    if (ramSize.equals(" ГБ")) {
                        product.setRam_size("0." + text1.substring(matcher.start(), matcher.end() - 3) + " ГБ");
                    } else
                        product.setRam_size(ramSize);
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
            if (tr.selectFirst("td").attr("class").equals("table-part")) {
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
                        product.setCpu_frequency(Double.valueOf(td.split(" ")[0]) / 1000);
                    if (th.contains("Количество ядер процессора"))
                        product.setCpu_cores_count(Integer.valueOf(td));
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
                    if (i == tableContent.size() - 1) break;
                    if (tableContent.get(i + 1).selectFirst("td").attr("class").equals("table-part")
                            || tableContent.get(i + 1).attr("class").equals("extended-characteristic hidden"))
                        break;
                }
                if (product.getGpu_discrete_model() == null)
                    product.setGpu_discrete_model(gpu_chip_type == null || gpu_model == null || gpu_chip_type.equals("нет") || gpu_model.equals("нет") ? null : gpu_chip_type + " " + gpu_model);
            }
        }
        return product;

    }

    public static Monitor setMonitor_citilink(Monitor product, String[] split) {
        String response_time = " ";
        String connector = " ";
        if (split.length > 1) {
            for (String str : split) {
                if (str.contains("экран: "))
                    product.setScreen(Double.valueOf(str.replace("экран: ", "").replace("\"", "")));
                if (str.contains("частота: "))
                    product.setScreen_frequency(Integer.parseInt(str.replace("частота: ", "").replace("Гц", "").trim()));
                if (str.contains("матрица ")) {
                    String[] arr = str.replace("матрица ", "").split(" ");
                    product.setScreen_resolution(arr[arr.length - 1]);
                    product.setMatrix_type(arr[0]);
                }
                if (str.contains("отношением сторон "))
                    product.setAspect_ratio(str.replace("отношением сторон ", ""));
                if (str.contains("яркостью "))
                    product.setBrightness(str.replace("яркостью ", ""));
                if (str.contains("временем отклика "))
                    response_time += str.replace("временем отклика ", "") + ", ";
                if (str.contains("разъем ") || str.contains("D-SUB") || str.contains("VGA") || str.contains("DVI") || str.contains("HDMI") || str.contains("Display Port"))
                    connector += str.replace("разъем ", "") + ", ";
            }
            product.setResponse_time(response_time.substring(0, response_time.length() - 1).equals("") ? null : response_time.substring(0, response_time.length() - 1));
            product.setConnector(connector.substring(0, connector.length() - 1).equals("") ? null : connector.substring(0, connector.length() - 1));
        }
        return product;
    }

    public static Monitor setMonitor_dns(Element content, Monitor product) {
        Elements tableContent = content.selectFirst("div[id=characteristics]").select("tr");
        for (int i = 0; i < tableContent.size(); i++) {
            Element tr = tableContent.get(i);
            if (tr.attr("class").equals("extended-characteristic hidden")) continue;
            if (tr.selectFirst("td").attr("class").equals("table-part")) {
                i++;
                for (int j = i; j < tableContent.size(); i++) {
                    if (tableContent.get(i).selectFirst("tr").attr("class").equals("extended-characteristic hidden"))
                        continue;
                    String th = tableContent.get(i).selectFirst("tr").selectFirst("span").text();
                    String td = tableContent.get(i).selectFirst("tr").select("td").get(1).text();
                    if (th.contains("Диагональ экрана"))
                        product.setScreen(Double.valueOf(td.replace("\"", "")));
                    if (th.contains("Максимальная частота обновления экрана"))
                        product.setScreen_frequency(Integer.parseInt(td.replace("Гц", "").trim()));
                    if (th.contains("Максимальное разрешение"))
                        product.setScreen_resolution(td);
                    if (th.contains("Соотношение сторон"))
                        product.setAspect_ratio(td);
                    if (th.contains("Яркость"))
                        product.setBrightness(td);
                    if (th.contains("Время отклика пикселя"))
                        product.setResponse_time(td.substring(0, td.length() - 1));
                    if (th.contains("Тип ЖК-матрицы (подробно)"))
                        product.setMatrix_type(td);
                    if (th.contains("Видеоразъемы"))
                        product.setConnector(td);

                    if (i == tableContent.size() - 1) break;
                    if (tableContent.get(i + 1).selectFirst("td").attr("class").equals("table-part")
                            || tableContent.get(i + 1).attr("class").equals("extended-characteristic hidden"))
                        break;
                }
            }
        }
        return product;
    }

    public static Printer setPrinter_citilink(Printer product, String[] split) {
        String connector = "";
        if (split.length > 1) {
            for (String str : split) {
                if (str.contains("технология печати: "))
                    product.setType(str.replace("технология печати: ", ""));
                if (str.contains("цветной") || str.contains("черно-белый"))
                    product.setColor(str.trim());
                if (str.contains("формат: "))
                    product.setFormat(str.replace("формат: ", ""));
                if (str.contains("максимальная скорость печати ")) {
                    //максимальная скорость печати (ЧБ) до 37 стр/мин
                    String text1 = str.replace("максимальная скорость печати ", "");
                    Pattern pattern = Pattern.compile("\\d+.?\\d*\\s*стр/мин");
                    Matcher matcher = pattern.matcher(text1);
                    if (matcher.find()) {
                        product.setMax_print_speed(Double.valueOf(text1.substring(matcher.start(), matcher.end() - 7).trim()));
                    } else
                        product.setMax_print_speed(null);
                }
                if (str.contains("USB") || str.contains("RJ-45") || str.contains("Wi-Fi") || str.contains("LPT"))
                    connector += str.trim() + ", ";
                if (str.contains("встроенная СНПЧ"))
                    product.setCISS("есть");
                if (str.contains("двусторонняя печать"))
                    product.setTwo_sided_printing("есть");
            }
            product.setConnector(connector.substring(0, connector.length() - 2));
        }
        return product;
    }

    public static Printer setPrinter_dns(Element content, Printer product) {
        Elements tableContent = content.selectFirst("div[id=characteristics]").select("tr");
        for (int i = 0; i < tableContent.size(); i++) {
            Element tr = tableContent.get(i);
            if (tr.attr("class").equals("extended-characteristic hidden")) continue;
            if (tr.selectFirst("td").attr("class").equals("table-part")) {
                i++;
                for (int j = i; j < tableContent.size(); i++) {
                    if (tableContent.get(i).selectFirst("tr").attr("class").equals("extended-characteristic hidden"))
                        continue;
                    String th = tableContent.get(i).selectFirst("tr").selectFirst("span").text();
                    String td = tableContent.get(i).selectFirst("tr").select("td").get(1).text();
                    if (th.contains("Технология печати"))
                        product.setType(td);
                    if (th.contains("Цветность печати"))
                        product.setColor(td);
                    if (th.contains("Максимальный формат"))
                        product.setFormat(td);
                    if (th.contains("Скорость чёрно-белой печати (стр/мин)")) {
//                        product.setMax_print_speed(Double.valueOf(td));
                        String text1 = td.replace("максимальная скорость печати ", "");
                        Pattern pattern = Pattern.compile("\\d+.?\\d*\\s*стр/мин");
                        Matcher matcher = pattern.matcher(text1);
                        if (matcher.find()) {
                            product.setMax_print_speed(Double.valueOf(text1.substring(matcher.start(), matcher.end() - 7).trim()));
                        } else
                            product.setMax_print_speed(null);
                    }
                    if (th.contains("Система непрерывной подачи чернил (СНПЧ)"))
                        product.setCISS(td);
                    if (th.contains("Автоматическая двусторонняя печать"))
                        product.setTwo_sided_printing(td);
                    if (th.contains("Интерфейсы"))
                        product.setConnector(td);

                    if (i == tableContent.size() - 1) break;
                    if (tableContent.get(i + 1).selectFirst("td").attr("class").equals("table-part")
                            || tableContent.get(i + 1).attr("class").equals("extended-characteristic hidden"))
                        break;
                }
            }
        }
        return product;
    }
}
