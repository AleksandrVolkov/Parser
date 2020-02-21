package com.java.sql.controller;


import com.java.sql.repos.*;
//import com.java.sql.repos.domain.*;
import com.java.sql.repos.domain.classess.Monitor;
import com.java.sql.repos.domain.classess.PC;
import com.java.sql.repos.domain.classess.Printer;
//import com.java.sql.repos.domain.product.Product;
import com.java.sql.repos.domain.product.Product;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.client.RestTemplate;
import test_pars.Parser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {
//    @Autowired
//    private UsersRepo usersRepo;
//    @Autowired
//    private PostRepo postRepo;

    @Autowired
    private PCRepo pcRepo;
    @Autowired
    private MonitorRepo monitorRepo;
    @Autowired
    private PrinterRepo printerRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {

        return "greeting";
    }

    public void citilink_monitor() throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Начинаем мониторы компы в ситилинке");
        String url1 = "https://www.citilink.ru/catalog/computers_and_notebooks/monitors/?available=1&status=55395790&p=1";
        Parser p = new Parser();
        Document page = p.getPage(url1);
        int lastPage = Integer.parseInt(page.selectFirst("div[class=page_listing]").selectFirst("li[class=last]").selectFirst("a").attr("data-page"));
        System.out.println("Мониторы ситилинка, последняя страница - " + lastPage + "\n\n");
        for (int i = 1; i < lastPage + 1; i++) {//7
            String url = "https://www.citilink.ru/catalog/computers_and_notebooks/monitors/?available=1&status=55395790&p=" + String.valueOf(i);
            monitorRepo.saveAll(p.citilink(url, Monitor.class));
            System.out.println("закончили парсить страницу " + i);
        }
        System.out.println("final");
    }

    public void citilink_pc() throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Начинаем парсить компы в ситилинке");
        String url1 = "https://www.citilink.ru/catalog/computers_and_notebooks/computers/?available=1&status=55395790&p=1";
        Parser p = new Parser();
        Document page = p.getPage(url1);
        int lastPage = Integer.parseInt(page.selectFirst("div[class=page_listing]").selectFirst("li[class=last]").selectFirst("a").attr("data-page"));
        System.out.println("ПК ситилинка, последняя страница - " + lastPage + "\n\n");
        for (int i = 1; i < lastPage + 1; i++) {
            String url = "https://www.citilink.ru/catalog/computers_and_notebooks/computers/?available=1&status=55395790&p=" + String.valueOf(i);
            pcRepo.saveAll(p.citilink(url, PC.class));
            System.out.println("закончили парсить страницу " + i);
        }
        System.out.println("final");
    }

    public void citilink_printer() throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Начинаем парсить принтеры в ситилинке");
        String url1 = "https://www.citilink.ru/catalog/computers_and_notebooks/monitors_and_office/printers/?available=1&status=55395790&p=1";
        Parser p = new Parser();
        Document page = p.getPage(url1);
        Elements elem = page.selectFirst("div[class=page_listing]").select("li[class=next]");//.selectFirst("a").attr("data-page"));
        List<Integer> lisNumPages = new ArrayList<>();
        for (Element e : elem) {
            lisNumPages.add(Integer.valueOf(e.selectFirst("a").attr("data-page")));
        }
        lisNumPages.sort(Integer::compareTo);
        int lastPage = lisNumPages.get(lisNumPages.size() - 1);
        System.out.println("Принтеры ситилинка, последняя страница - " + lastPage + "\n\n");
        for (int i = 1; i < lastPage + 1; i++) {
            String url = "https://www.citilink.ru/catalog/computers_and_notebooks/monitors_and_office/printers/?available=1&status=55395790&p=" + String.valueOf(i);
            printerRepo.saveAll(p.citilink(url, Printer.class));
            System.out.println("закончили парсить страницу " + i);
        }
        System.out.println("final");

        String url2 = "https://www.citilink.ru/catalog/computers_and_notebooks/monitors_and_office/ink_printers/?available=1&status=55395790&p=1";
        Document page1 = p.getPage(url2);
        Elements elem1 = page1.selectFirst("div[class=page_listing]").select("li[class=next]");//.selectFirst("a").attr("data-page"));
        List<Integer> lisNumPages1 = new ArrayList<>();
        for (Element e : elem1) {
            lisNumPages1.add(Integer.valueOf(e.selectFirst("a").attr("data-page")));
        }
        lisNumPages1.sort(Integer::compareTo);
        lastPage = lisNumPages1.get(lisNumPages1.size() - 1);
        System.out.println("Принтеры ситилинка, последняя страница - " + lastPage + "\n\n");

        System.out.println("Начинаем парсить принтеры в ситилинке");

        for (int i = 1; i < lastPage + 1; i++) {
            String url = "https://www.citilink.ru/catalog/computers_and_notebooks/monitors_and_office/ink_printers/?available=1&status=55395790&p=" + String.valueOf(i);
            printerRepo.saveAll(p.citilink(url, Printer.class));
            System.out.println("закончили парсить страницу " + i);
        }
        System.out.println("final");
    }

    @PostMapping("/citilink_pc")
    public String greetingParseCitilink_PC(Map<String, Object> model) throws IOException, InterruptedException, URISyntaxException {
//        String url1 = "https://www.citilink.ru/catalog/computers_and_notebooks/computers/?available=1&status=55395790&p=1";
//        Parser p = new Parser();
//        Document page = p.getPage(url1);
//        int lastPage = Integer.parseInt(page.selectFirst("div[class=page_listing]").selectFirst("li[class=last]").selectFirst("a").attr("data-page"));
//        System.out.println("ПК ситилинка, последняя страница - " + lastPage + "\n\n");
////        int count = 0;
//        for (int i = 1; i < lastPage + 1; i++) {
//            String url = "https://www.citilink.ru/catalog/computers_and_notebooks/computers/?available=1&status=55395790&p=" + String.valueOf(i);
////            url="https://www.citilink.ru/catalog/computers_and_notebooks/computers/?available=1&status=55395790&p=10";
////            for (Product product : p.citilink(url, PC.class)) {
////                pcRepo.findById_product(product.getId_product());
//            pcRepo.saveAll(p.citilink(url, PC.class));
////            }
//            System.out.println(i);
//        }
//        System.out.println("final");
////        return "greeting";
        citilink_pc();
        return "redirect:/";
    }

    @PostMapping("/citilink_monitor")
    public String greetingParseCitilink_Monitor(Map<String, Object> model) throws IOException, InterruptedException, URISyntaxException {
//        String url1 = "https://www.citilink.ru/catalog/computers_and_notebooks/monitors/?available=1&status=55395790&p=1";
//        Parser p = new Parser();
//        Document page = p.getPage(url1);
//        int lastPage = Integer.parseInt(page.selectFirst("div[class=page_listing]").selectFirst("li[class=last]").selectFirst("a").attr("data-page"));
//        System.out.println("Мониторы ситилинка, последняя страница - " + lastPage + "\n\n");
//        for (int i = 1; i < lastPage + 1; i++) {//7
//            String url = "https://www.citilink.ru/catalog/computers_and_notebooks/monitors/?available=1&status=55395790&p=" + String.valueOf(i);
////            List<Product> pl = p.citilink(url, Monitor.class);
////            for (Product prod : pl) {
//            monitorRepo.saveAll(p.citilink(url, Monitor.class));
////            System.out.println(1);
////            }
//
//            System.out.println(i);
//
//        }
//        System.out.println("final");
        citilink_monitor();
        return "redirect:/";
    }

    @PostMapping("/citilink_printer")
    public String greetingParseCitilink_Printer(Map<String, Object> model) throws IOException, InterruptedException, URISyntaxException {
//        String url1 = "https://www.citilink.ru/catalog/computers_and_notebooks/monitors_and_office/printers/?available=1&status=55395790&p=1";
//        Parser p = new Parser();
//        Document page = p.getPage(url1);
//        Elements elem = page.selectFirst("div[class=page_listing]").select("li[class=next]");//.selectFirst("a").attr("data-page"));
//        List<Integer> lisNumPages = new ArrayList<>();
//        for (Element e : elem) {
//            lisNumPages.add(Integer.valueOf(e.selectFirst("a").attr("data-page")));
//        }
//        lisNumPages.sort(Integer::compareTo);
//        int lastPage = lisNumPages.get(lisNumPages.size() - 1);
//        for (int i = 1; i < lastPage + 1; i++) {
//            String url = "https://www.citilink.ru/catalog/computers_and_notebooks/monitors_and_office/printers/?available=1&status=55395790&p=" + String.valueOf(i);
//            printerRepo.saveAll(p.citilink(url, Printer.class));
//            System.out.println(i);
//        }
//        System.out.println("final");
//
//        String url2 = "https://www.citilink.ru/catalog/computers_and_notebooks/monitors_and_office/ink_printers/?available=1&status=55395790&p=1";
//        Document page1 = p.getPage(url2);
//        Elements elem1 = page1.selectFirst("div[class=page_listing]").select("li[class=next]");//.selectFirst("a").attr("data-page"));
//        List<Integer> lisNumPages1 = new ArrayList<>();
//        for (Element e : elem1) {
//            lisNumPages1.add(Integer.valueOf(e.selectFirst("a").attr("data-page")));
//        }
//        lisNumPages1.sort(Integer::compareTo);
//        lastPage = lisNumPages1.get(lisNumPages1.size() - 1);
//        for (int i = 1; i < lastPage + 1; i++) {
//            String url = "https://www.citilink.ru/catalog/computers_and_notebooks/monitors_and_office/ink_printers/?available=1&status=55395790&p=" + String.valueOf(i);
//            printerRepo.saveAll(p.citilink(url, Printer.class));
//            System.out.println(i);
//        }
//        System.out.println("final");
        citilink_printer();
        return "redirect:/";
    }

    public void dns_pc() throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Начинаем парсить компы в dns");
        int lastPage = 0;
        String url1 = "https://www.dns-shop.ru/catalog/17a8932c16404e77/sistemnye-bloki/?p=15&order=1&groupBy=none&stock=2";
        Parser p = new Parser();
        Document page = p.getPage(url1);
        Elements elements = page.select("div[id=products-list-pagination]").first().select("li[class=pagination-widget__page]");
        for (Element el : elements)
            if (el.selectFirst("a").attr("class").contains("pagination-widget__page-link pagination-widget__page-link_last "))
                lastPage = Integer.parseInt(el.attr("data-page-number"));
        System.out.println("ПК dns, последняя страница - " + lastPage + "\n\n");
        for (int i = 1; i < lastPage + 1; i++) {
            String url = "https://www.dns-shop.ru/catalog/17a8932c16404e77/sistemnye-bloki/?p=" + String.valueOf(i) + "&order=1&groupBy=none&stock=2";
            pcRepo.saveAll(p.DNS(url, PC.class));
            System.out.println("закончили парсить страницу " + i);
        }
        System.out.println("final");
    }

    public void dns_monitor() throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Начинаем парсить моники в dns");
        int lastPage = 0;
        String url1 = "https://www.dns-shop.ru/catalog/17a8943716404e77/monitory/?p=1&order=1&groupBy=none&stock=2&q=%D0%BC%D0%BE%D0%BD%D0%B8%D1%82%D0%BE%D1%80";
        Parser p = new Parser();
        Document page = p.getPage(url1);
        Elements elements = page.select("div[id=products-list-pagination]").first().select("li[class=pagination-widget__page]");
        for (Element el : elements)
            if (el.selectFirst("a").attr("class").contains("pagination-widget__page-link pagination-widget__page-link_last"))
                lastPage = Integer.parseInt(el.attr("data-page-number"));
        System.out.println("Мониторы dns, последняя страница - " + lastPage + "\n\n");

        for (int i = 1; i < lastPage + 1; i++) {
            String url = "https://www.dns-shop.ru/catalog/17a8943716404e77/monitory/?p=" + String.valueOf(i) + "&order=1&groupBy=none&stock=2&q=%D0%BC%D0%BE%D0%BD%D0%B8%D1%82%D0%BE%D1%80";
            monitorRepo.saveAll(p.DNS(url, Monitor.class));
            System.out.println("закончили парсить страницу " + i);
        }
        System.out.println("final");
    }

    public void dns_printer() throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Начинаем парсить принтеры в dns");
        int lastPage = 0;
        Parser p = new Parser();

        String url1 = "https://www.dns-shop.ru/catalog/17a8e00716404e77/lazernye-printery/?p=1&order=1&groupBy=none&stock=2&q=%D0%BF%D1%80%D0%B8%D0%BD%D1%82%D0%B5%D1%80";
        Document page = p.getPage(url1);
        Elements elements = page.select("div[id=products-list-pagination]").first().select("li[class=pagination-widget__page]");
        for (Element el : elements)
            if (el.selectFirst("a").attr("class").contains("pagination-widget__page-link pagination-widget__page-link_last"))
                lastPage = Integer.parseInt(el.attr("data-page-number"));
        System.out.println("Принтеры dns, последняя страница - " + lastPage + "\n\n");

        for (int i = 1; i < lastPage + 1; i++) {
            String url = "https://www.dns-shop.ru/catalog/17a8e00716404e77/lazernye-printery/?p=" + String.valueOf(i) + "&order=1&groupBy=none&stock=2&q=%D0%BF%D1%80%D0%B8%D0%BD%D1%82%D0%B5%D1%80";
            printerRepo.saveAll(p.DNS(url, Printer.class));
            System.out.println("закончили парсить страницу " + i);
        }
        System.out.println("final");

        lastPage = 0;
        String url2 = "https://www.dns-shop.ru/catalog/17a8e07216404e77/strujnye-printery/?p=1&order=1&groupBy=none&stock=2&f[nz8]=9hd9&q=%D0%BF%D1%80%D0%B8%D0%BD%D1%82%D0%B5%D1%80%D1%8B";
        Document page1 = p.getPage(url2);
        try {
            Elements elements1 = page1.select("div[id=products-list-pagination]").first().select("li[class=pagination-widget__page]");
            for (Element el : elements1)
                if (el.selectFirst("a").attr("class").contains("pagination-widget__page-link pagination-widget__page-link_last"))
                    lastPage = Integer.parseInt(el.attr("data-page-number"));

        } catch (Exception e) {
            lastPage = 1;
            System.out.println("Ошибка в чтении div[id=products-list-pagination], по дефолту стр. = 1");
        }
        System.out.println("Принтеры dns, последняя страница - " + lastPage + "\n\n");


        for (int i = 1; i < lastPage + 1; i++) {
            String url = "https://www.dns-shop.ru/catalog/17a8e07216404e77/strujnye-printery/?p=" + String.valueOf(i) + "&order=1&groupBy=none&stock=2&f[nz8]=9hd9&q=%D0%BF%D1%80%D0%B8%D0%BD%D1%82%D0%B5%D1%80%D1%8B";
            printerRepo.saveAll(p.DNS(url, Printer.class));
            System.out.println("закончили парсить страницу " + i);
        }
        System.out.println("final");

    }

    @PostMapping("/dns_pc")
    public String greetingParseDNS_PC(Map<String, Object> model) throws IOException, URISyntaxException, InterruptedException {
//        int lastPage = 0;
//        String url1 = "https://www.dns-shop.ru/catalog/17a8932c16404e77/sistemnye-bloki/?p=15&order=1&groupBy=none&stock=2";
//        //https://www.dns-shop.ru/catalog/17a8932c16404e77/sistemnye-bloki/?p=15&order=1&groupBy=none&stock=2
//        Parser p = new Parser();
//        Document page = p.getPage(url1);
//        Elements elements = page.select("div[id=products-list-pagination]").first().select("li[class=pagination-widget__page]");
////<li class="pagination-widget__page" data-role="pagination-page" data-page-number="15"><a href="javascript:" class="pagination-widget__page-link pagination-widget__page-link_last pagination-widget__page-link_disabled"></a></li>
//        for (Element el : elements)
//            if (el.selectFirst("a").attr("class").contains("pagination-widget__page-link pagination-widget__page-link_last "))
//                lastPage = Integer.parseInt(el.attr("data-page-number"));
//
//        for (int i = 1; i < lastPage + 1; i++) {
//            String url = "https://www.dns-shop.ru/catalog/17a8932c16404e77/sistemnye-bloki/?p=" + String.valueOf(i) + "&order=1&groupBy=none&stock=2";
////            for (Product product : p.DNS_PC(url,PC.class)) {
////                pcRepo.save(product);
//            pcRepo.saveAll(p.DNS(url, PC.class));
////            }
//            System.out.println(i);
//        }
//        System.out.println("final");
        dns_pc();

//        return "greeting";
        return "redirect:/";

    }

    @PostMapping("/dns_monitor")
    public String greetingParseDNS_Monitor(Map<String, Object> model) throws IOException, URISyntaxException, InterruptedException {
//        int lastPage = 0;
//        String url1 = "https://www.dns-shop.ru/catalog/17a8943716404e77/monitory/?p=1&order=1&groupBy=none&stock=2&q=%D0%BC%D0%BE%D0%BD%D0%B8%D1%82%D0%BE%D1%80";
//        Parser p = new Parser();
//        Document page = p.getPage(url1);
//        Elements elements = page.select("div[id=products-list-pagination]").first().select("li[class=pagination-widget__page]");
//        for (Element el : elements)
//            if (el.selectFirst("a").attr("class").contains("pagination-widget__page-link pagination-widget__page-link_last"))
//                lastPage = Integer.parseInt(el.attr("data-page-number"));
//        for (int i = 1; i < lastPage + 1; i++) {
//            String url = "https://www.dns-shop.ru/catalog/17a8943716404e77/monitory/?p=" + String.valueOf(i) + "&order=1&groupBy=none&stock=2&q=%D0%BC%D0%BE%D0%BD%D0%B8%D1%82%D0%BE%D1%80";
//            monitorRepo.saveAll(p.DNS(url, Monitor.class));
//            System.out.println(i);
//
//        }
//        System.out.println("final");
        dns_monitor();
        return "redirect:/";

    }

    @PostMapping("/dns_printer")
    public String greetingParseDNS_Printer(Map<String, Object> model) throws IOException, URISyntaxException, InterruptedException {
//        int lastPage = 0;
//        Parser p = new Parser();
//
//        String url1 = "https://www.dns-shop.ru/catalog/17a8e00716404e77/lazernye-printery/?p=1&order=1&groupBy=none&stock=2&q=%D0%BF%D1%80%D0%B8%D0%BD%D1%82%D0%B5%D1%80";
//        Document page = p.getPage(url1);
//        Elements elements = page.select("div[id=products-list-pagination]").first().select("li[class=pagination-widget__page]");
//        for (Element el : elements)
//            if (el.selectFirst("a").attr("class").contains("pagination-widget__page-link pagination-widget__page-link_last"))
//                lastPage = Integer.parseInt(el.attr("data-page-number"));
//        for (int i = 1; i < lastPage + 1; i++) {
//            String url = "https://www.dns-shop.ru/catalog/17a8e00716404e77/lazernye-printery/?p=" + String.valueOf(i) + "&order=1&groupBy=none&stock=2&q=%D0%BF%D1%80%D0%B8%D0%BD%D1%82%D0%B5%D1%80";
//            printerRepo.saveAll(p.DNS(url, Printer.class));
//            System.out.println(i);
//        }
//        System.out.println("final");
//
//        lastPage = 0;
//        String url2 = "https://www.dns-shop.ru/catalog/17a8e07216404e77/strujnye-printery/?p=1&order=1&groupBy=none&stock=2&f[nz8]=9hd9&q=%D0%BF%D1%80%D0%B8%D0%BD%D1%82%D0%B5%D1%80%D1%8B";
//        Document page1 = p.getPage(url2);
//        try {
//            Elements elements1 = page1.select("div[id=products-list-pagination]").first().select("li[class=pagination-widget__page]");
//            for (Element el : elements1)
//                if (el.selectFirst("a").attr("class").contains("pagination-widget__page-link pagination-widget__page-link_last"))
//                    lastPage = Integer.parseInt(el.attr("data-page-number"));
//        } catch (Exception e) {
//            lastPage = 1;
//            e.printStackTrace();
//        }
//
//        for (int i = 1; i < lastPage + 1; i++) {
//            String url = "https://www.dns-shop.ru/catalog/17a8e07216404e77/strujnye-printery/?p=" + String.valueOf(i) + "&order=1&groupBy=none&stock=2&f[nz8]=9hd9&q=%D0%BF%D1%80%D0%B8%D0%BD%D1%82%D0%B5%D1%80%D1%8B";
//            printerRepo.saveAll(p.DNS(url, Printer.class));
//            System.out.println(i);
//        }
//        System.out.println("final");
        dns_printer();

        return "redirect:/";

    }

    @PostMapping("/dns_all")
    public String greetingParseDNS_ALL(Map<String, Object> model) throws IOException, URISyntaxException, InterruptedException {
        dns_pc();
        dns_monitor();
        dns_printer();
        return "redirect:/";
    }

    @PostMapping("/citilink_all")
    public String greetingParseCitilink_ALL(Map<String, Object> model) throws IOException, InterruptedException, URISyntaxException {
        citilink_pc();
        citilink_monitor();
        citilink_printer();
        return "redirect:/";
    }

//    @GetMapping("/main")
//    public String main(Map<String, Object> model) {
//        Iterable<Users> users = usersRepo.findAll();
//        model.put("users", users);
//        return "main";
//    }
//
//    @PostMapping("/add")
//    public String add(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String login, Map<String, Object> model) {
//        Iterable<Users> users;
//        if (firstName != null && !firstName.isEmpty() &&
//                lastName != null && !lastName.isEmpty() &&
//                login != null && !login.isEmpty()) {
//
//            Users user = new Users(firstName, lastName, login);
//            usersRepo.save(user);
//            users = usersRepo.findAll();
//        } else {
//            users = usersRepo.findAll();
//        }
//        model.put("users", users);
//        return "main";
//    }
//
//    @PostMapping("/remove")
//    public String remove(@RequestParam String id, Map<String, Object> model) {
//        usersRepo.deleteById(Long.parseLong(id));
//        Iterable<Users> users = usersRepo.findAll();
//
//        model.put("users", users);
//        return "main";
//    }
//
//    @PostMapping("/edit")
//    public String edit(@RequestParam String id, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String login, Map<String, Object> model) {
//        usersRepo.findById(Long.parseLong(id)).get().setFirstName(firstName);
//        usersRepo.findById(Long.parseLong(id)).get().setLastName(lastName);
//        usersRepo.findById(Long.parseLong(id)).get().setLogin(login);
//        Iterable<Users> users = usersRepo.findAll();
//
//        model.put("users", users);
//        return "main";
//    }
//
//    @PostMapping("/add_api")
//    public String add_api(Map<String, Object> model) {
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<List<Post>> rateResponse =
//                restTemplate.exchange("http://jsonplaceholder.typicode.com/posts?_limit=10",
//                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Post>>() {
//                        });
//        List<Post> postsList = rateResponse.getBody();
//
//        for (Post p : postsList) {
//            Post post = new Post(p.getTitle(), p.getBody(), p.getUserId());
//            postRepo.save(post);
//        }
//        Iterable<Post> posts = postRepo.findAll();
//
//        model.put("posts", posts);
//
//        return "main";
//    }
//
//    @PostMapping("/remove_all_api")
//    public String remove_api(Map<String, Object> model) {
//        try {
//            postRepo.deleteAll();
//        } catch (Exception e) {
//        }
//        return "main";
//    }
}
