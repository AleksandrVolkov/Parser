//package com.java.sql.service;
//
//import com.java.sql.repos.*;
//import com.java.sql.repos.domain.pc.classess.*;
//import com.java.sql.repos.domain.product.Product;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import test_pars.FullProduct;
//
//import java.util.Map;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//@Service
//public class DBService {
//    @Autowired
//    private BodyRepo bodyRepo;
//    @Autowired
//    private CommunicationsRepo communicationsRepo;
//    @Autowired
//    private ConnectorsRepo connectorsRepo;
//    @Autowired
//    private CPURepo cpuRepo;
//    @Autowired
//    private DiskRepo diskRepo;
//    @Autowired
//    private GeneralInformationRepo generalInformationRepo;
//    @Autowired
//    private GPURepo gpuRepo;
//    @Autowired
//    private ImagesRepo imagesRepo;
//    @Autowired
//    private OSRepo osRepo;
//    @Autowired
//    private ProductRepo productRepo;
//    @Autowired
//    private RAMRepo ramRepo;
//
//    public void fillProduct(Product product) {
//        productRepo.save(product);
//        System.out.printf("+ ");
//    }
//
//    public void fillAllFieldPC(Long id, FullProduct fullProduct) {
//        //заполняю таблицу картинками с нужным id
//        for (String im : fullProduct.getImageList()) {
//            imagesRepo.save(new Images(id, im));
//        }
//        Map<String, Map<String, String>> mp = fullProduct.getFullProductDescription();
//        Body body = new Body();
//
//        for (Map.Entry<String, Map<String, String>> entry : mp.entrySet()) {
//            Map<String, String> value = entry.getValue();
//            String key = entry.getKey();
//            switch (key) {
//                case ("Оперативная память"):
//                    RAM ram = new RAM();
//                    ram.setID(id);
//                    for (Map.Entry<String, String> val : value.entrySet()) {
//                        if (val.getKey().equals("Оперативная память") || val.getKey().equals("Тип оперативной памяти"))
//                            if (val.getKey().equals("Оперативная память"))
//                                try {
//                                    ram.setRAM_model(val.getValue().split(" ")[0] + val.getValue().split(" ")[1]);
//                                } catch (Exception e) {
//                                    ram.setRAM_model(val.getValue());
////                                    System.out.println(val.getValue());
//                                }
//                            else
//                                ram.setRAM_model(val.getValue());
//                        if (val.getKey().equals("Максимальный объем оперативной памяти"))
//                            ram.setRAM_max_size(val.getValue());
//                        if (val.getKey().equals("Размер оперативной памяти") || val.getKey().equals("Оперативная память")) {
//                            if (val.getKey().equals("Оперативная память")) {
//                                try {
//                                    String text = val.getValue();
//                                    Pattern pattern = Pattern.compile("\\d+\\s+Мб");
//                                    Matcher matcher = pattern.matcher(text);
//                                    matcher.find();
//                                    String ramSize = text.substring(matcher.start(), matcher.end() - 6) + " ГБ";
//                                    ram.setRAM_current_size(ramSize);
//                                } catch (Exception e) {
////                                    System.out.println(val.getValue());
//                                    ram.setRAM_current_size(null);
//                                }
//
//                            } else
//                                ram.setRAM_current_size(val.getValue());
//                        }
//                    }
//                    ramRepo.save(ram);
//                    break;
//                case ("Графический адаптер"):
//                case ("Видеокарта"):
//                    GPU gpu = new GPU();
//                    gpu.setID(id);
//                    String gpuName = "";
//                    for (Map.Entry<String, String> val : value.entrySet()) {
//                        if (val.getKey().equals("Тип графического контроллера") || val.getKey().equals("Тип видеокарты"))
//                            gpu.setGPU_type(val.getValue());
//                        if (val.getKey().equals("Графика"))
//                            gpuName = val.getValue();
//                        if (val.getKey().equals("Модель интегрированной видеокарты"))
//                            gpu.setGPU_integrated_model(val.getValue());
//                        if (val.getKey().equals("Модель дискретной видеокарты"))
//                            gpu.setGPU_discrete_model(val.getValue());
//                        if (val.getKey().equals("Графика") || val.getKey().equals("Объем видеопамяти")) {
//                            if (val.getKey().equals("Объем видеопамяти"))
//                                gpu.setGPU_size(val.getValue());
//                            if (val.getKey().equals("Графика")) {
//                                try {
//                                    String text = val.getValue();
//                                    Pattern pattern = Pattern.compile("\\d+\\s+Мб");
//                                    Matcher matcher = pattern.matcher(text);
//                                    matcher.find();
//                                    String gpuSize = text.substring(matcher.start(), matcher.end());
//                                    gpu.setGPU_size(gpuSize);
//                                } catch (Exception e) {
//                                    gpu.setGPU_size("выделяется из оперативной");
//                                }
//                            }
//                        }
//                    }
//                    if (gpu.getGPU_integrated_model() == null)
//                        if (gpu.getGPU_type().equals("встроенная") || gpu.getGPU_type().equals("интегрированный"))
//                            gpu.setGPU_integrated_model(gpuName);
//                    if (gpu.getGPU_discrete_model() == null)
//                        if (gpu.getGPU_type().equals("дискретный") || gpu.getGPU_type().equals("дискретная"))
//                            gpu.setGPU_discrete_model(gpuName);
//                    gpuRepo.save(gpu);
//                    break;
//                case ("Коммуникации"):
//                case ("Интернет/передача данных"):
//                    for (Map.Entry<String, String> val : value.entrySet()) {
//                        if (!val.getKey().equals("Скорость сетевого адаптера"))
//                            communicationsRepo.save(new Communications(id, val.getValue()));
//                    }
//                    break;
//                case ("Корпус"):
//                case ("Общие параметры"):
//                    body.setID(id);
//                    for (Map.Entry<String, String> val : value.entrySet()) {
//                        if (val.getKey().equals("Вес"))
//                            body.setWeight(val.getValue());
//                        if (val.getKey().equals("Блок питания"))
//                            body.setPower_supply_voltage(val.getValue());
//                        if (val.getKey().equals("Тип блока питания"))
//                            body.setPower_supply_type(val.getValue());
//                        if (val.getKey().equals("Тип корпуса") || val.getKey().equals("Форм-фактор корпуса"))
//                            body.setBody_type(val.getValue());
//                        if (val.getKey().equals("Цвет корпуса") || val.getKey().equals("Основной цвет"))
//                            body.setColor(val.getValue());
//                        if (val.getKey().equals("Размеры корпуса (ШхВхГ)"))
//                            body.setSize(val.getValue());
//                    }
//                    break;
//                case ("Габариты"):
//                    String bodySize = "";
//                    for (Map.Entry<String, String> val : value.entrySet()) {
//                        if (val.getKey().equals("Длина"))
//                            bodySize += val.getValue();
//                        else {
//                            String str = val.getValue();
//                            bodySize = str.split(" ")[0] + " x " + bodySize;
//                        }
//                    }
//                    body.setSize(bodySize);
//                    break;
//                case ("Хранение информации"):
//                case ("Накопители данных"):
//                    for (Map.Entry<String, String> val : value.entrySet())
//                        diskRepo.save(new Disk(id, val.getKey(), val.getValue()));
//                    break;
//                case ("Разъемы"):
//                case ("Интерфейсы/разъемы"):
//                    int jackCount = 0;
//                    Connectors connectors = new Connectors();
//                    connectors.setID(id);
//                    for (Map.Entry<String, String> val : value.entrySet()) {
//                        if (val.getKey().equals("Разъемов PS/2"))
//                            connectors.setPS2(val.getValue());
//                        if (val.getKey().equals("Разъемов USB 2.0"))
//                            connectors.setUSB_20(val.getValue());
//                        if (val.getKey().equals("Разъемов USB 3.0"))
//                            connectors.setUSB_30(val.getValue());
//                        if (val.getKey().equals("Разъемов RS-232"))
//                            connectors.setRS232(val.getValue());
//                        if (val.getKey().equals("Разъемов D-Sub"))
//                            connectors.setDSub(val.getValue());
//                        if (val.getKey().equals("Разъемов HDMI"))
//                            connectors.setHDMI(val.getValue());
//                        if (val.getKey().equals("Разъем для микрофона"))
//                            jackCount++;
//                        if (val.getKey().equals("Разъем для наушников"))
//                            jackCount++;
//                        if (val.getKey().equals("Разъем наушники/микрофон"))
//                            jackCount++;
//                        if (val.getKey().equals("Разъемов DisplayPort"))
//                            connectors.setDisplayPort(val.getValue());
//                        if (val.getKey().equals("Разъемов USB 3.1"))
//                            connectors.setUSB_31(val.getValue());
//                        if (val.getKey().equals("Разъемов USB 3.0 (Type-C)"))
//                            connectors.setUSB_30TypeC(val.getValue());
//                        if (val.getKey().equals("Разъемов DVI"))
//                            connectors.setDVI(val.getValue());
//                        if (val.getKey().equals("Видео интерфейсы")) {
//                            if (val.getValue().contains("DVI") || val.getValue().contains("DVI-D"))
//                                connectors.setDVI("1");
//                            if (val.getValue().contains("HDMI"))
//                                connectors.setHDMI("1");
//                            if (val.getValue().contains("VGA") || val.getValue().contains("D-Sub"))
//                                connectors.setDSub("1");
//                            if (val.getValue().contains("DisplayPort"))
//                                connectors.setDisplayPort("1");
//                        }
//                        if (val.getKey().equals("Интерфейсы периферии")) {
//                            for (String s : val.getValue().split(",")) {
//                                if (s.contains("jack"))
//                                    connectors.setJack35mm(s.substring(s.length() - 1).equals("m") ? "1" : s.substring(s.length() - 1));
//                                if (s.contains("USB 2.0"))
//                                    connectors.setUSB_20(s.substring(s.length() - 1));
//                                if (s.contains("USB 3.0"))
//                                    connectors.setUSB_30(s.substring(s.length() - 1));
//                                if (s.contains("USB Type-C"))
//                                    connectors.setUSB_30("1");
//                            }
//                        }
//                    }
//                    if (connectors.getJack35mm() == null)
//                        connectors.setJack35mm(String.valueOf(jackCount));
//                    connectorsRepo.save(connectors);
//                    break;
//                case ("Программное обеспечение"):
//                    OS os = new OS();
//                    os.setID(id);
//                    for (Map.Entry<String, String> val : value.entrySet()) {
//                        if (val.getKey().equals("Операционная система"))
//                            os.setOS_name(val.getValue());
//                        if (val.getKey().equals("Разрядность ОС"))
//                            os.setOS_capacity(val.getValue());
//                    }
//                    osRepo.save(os);
//                    break;
//                case ("Процессор"):
//                    CPU cpu = new CPU();
//                    cpu.setID(id);
//                    for (Map.Entry<String, String> val : value.entrySet()) {
//                        if (val.getKey().equals("Сокет процессора"))
//                            cpu.setCPU_socket(val.getValue());
//                        if (val.getKey().equals("Процессор") || val.getKey().equals("Модель процессора"))
//                            cpu.setCPU_model(val.getValue());
//                        if (val.getKey().equals("Процессор, частота") || val.getKey().equals("Частота процессора"))
//                            cpu.setCPU_frequency(val.getValue());
//                        if (val.getKey().equals("Количество ядер процессора"))
//                            cpu.setCPU_cores(val.getValue());
//                        if (val.getKey().equals("Чипсет материнской платы"))
//                            cpu.setCPU_chipset(val.getValue());
//                    }
//                    cpuRepo.save(cpu);
//                    break;
//                case (""):
//                    GeneralInformation generalInformation = new GeneralInformation();
//                    generalInformation.setID(id);
//                    for (Map.Entry<String, String> val : value.entrySet()) {
//                        if (val.getKey().equals("Гарантия"))
//                            generalInformation.setWarranty(val.getValue());
//                        if (val.getKey().equals("Сайт производителя"))
//                            generalInformation.setProducts_webpage(val.getValue());
//                        if (val.getKey().equals("Страна производитель"))
//                            generalInformation.setCountry_manufacture(val.getValue());
//                    }
//                    generalInformationRepo.save(generalInformation);
//                    break;
//            }
//        }
//        System.out.printf("+    ");
//        bodyRepo.save(body);
//    }
//
//
//}
