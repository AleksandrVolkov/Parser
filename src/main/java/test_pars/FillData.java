//package test_pars;
//
//import com.java.sql.repos.*;
//import com.java.sql.repos.domain.pc.classess.*;
//import com.java.sql.repos.domain.product.Product;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Map;
//
//public class FillData {
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
//
//    public void fillProduct(Product product) {
//        productRepo.save(product);
//    }
//
//    public void fillUnField(Long id, FullProduct fullProduct) {
//        //заполняю таблицу картинками с нужным id
//        for (String im : fullProduct.getImageList()) {
//            imagesRepo.save(new Images(id, im));
//        }
//        Map<String, Map<String, String>> mp = fullProduct.getFullProductDescription();
//
//        for (Map.Entry<String, Map<String, String>> entry : mp.entrySet()) {
//            Map<String, String> value = entry.getValue();
//            String key = entry.getKey();
//            switch (key) {
//                case ("Оперативная память"):
//                    RAM ram = new RAM();
//                    ram.setID(id);
//                    for (Map.Entry<String, String> val : value.entrySet()) {
//                        if (val.getKey().equals("Оперативная память"))
//                            ram.setRAM_model(val.getKey() + " -> " + val.getValue());
//                        if (val.getKey().equals("Максимальный объем оперативной памяти"))
//                            ram.setRAM_max_size(val.getKey() + " -> " + val.getValue());
//                        if (val.getKey().equals("Размер оперативной памяти"))
//                            ram.setRAM_current_size(val.getKey() + " -> " + val.getValue());
//                    }
//                    ramRepo.save(ram);
//                    break;
//                case ("Графический адаптер"):
//                    GPU gpu = new GPU();
//                    gpu.setID(id);
//                    for (Map.Entry<String, String> val : value.entrySet()) {
//                        if (val.getKey().equals("Тип графического контроллера"))
//                            gpu.setGPU_type(val.getKey() + " -> " + val.getValue());
////                        if (val.getKey().equals("Графика"))
////                            gpu.setGPU_model(val.getKey() + " -> " + val.getValue());
//                    }
//                    gpuRepo.save(gpu);
//                    break;
//
//                case ("Коммуникации"):
//                    for (Map.Entry<String, String> val : value.entrySet()) {
//                        communicationsRepo.save(new Communications(id, val.getKey() + " -> " + val.getValue()));
//                    }
//                    break;
//                case ("Корпус"):
//                    Body body = new Body();
//                    body.setID(id);
//                    for (Map.Entry<String, String> val : value.entrySet()) {
//                        if (val.getKey().equals("Вес"))
//                            body.setWeight(val.getKey() + " -> " + val.getValue());
//                        if (val.getKey().equals("Блок питания"))
//                            body.setPower_supply_voltage(val.getKey() + " -> " + val.getValue());
//                        if (val.getKey().equals("Тип блока питания"))
//                            body.setPower_supply_type(val.getKey() + " -> " + val.getValue());
//                        if (val.getKey().equals("Тип корпуса"))
//                            body.setBody_type(val.getKey() + " -> " + val.getValue());
//                        if (val.getKey().equals("Цвет корпуса"))
//                            body.setColor(val.getKey() + " -> " + val.getValue());
//                        if (val.getKey().equals("Размеры корпуса (ШхВхГ)"))
//                            body.setSize(val.getKey() + " -> " + val.getValue());
//                    }
//                    bodyRepo.save(body);
//                    break;
//                case ("Хранение информации"):
//                    for (Map.Entry<String, String> val : value.entrySet()) {
////                        diskRepo.save(new Disk(id, val.getKey() + " -> " + val.getValue()));
//                    }
//                    break;
//                case ("Разъемы"):
//                    Connectors connectors = new Connectors();
//                    connectors.setID(id);
//                    for (Map.Entry<String, String> val : value.entrySet()) {
//                        if (val.getKey().equals("Разъемов PS/2"))
//                            connectors.setPS2(val.getKey() + " -> " + val.getValue());
//                        if (val.getKey().equals("Разъемов USB 2.0"))
//                            connectors.setUSB_20(val.getKey() + " -> " + val.getValue());
//                        if (val.getKey().equals("Разъемов USB 3.0"))
//                            connectors.setUSB_30(val.getKey() + " -> " + val.getValue());
//                        if (val.getKey().equals("Разъемов RS-232"))
//                            connectors.setRS232(val.getKey() + " -> " + val.getValue());
//                        if (val.getKey().equals("Разъемов D-Sub"))
//                            connectors.setDSub(val.getKey() + " -> " + val.getValue());
//                        if (val.getKey().equals("Разъемов HDMI"))
//                            connectors.setHDMI(val.getKey() + " -> " + val.getValue());
////                        if (val.getKey().equals("Разъем для микрофона"))
////                            connectors.setMicrophone(val.getKey() + " -> " + val.getValue());
////                        if (val.getKey().equals("Разъем для наушников"))
////                            connectors.setHeadphones(val.getKey() + " -> " + val.getValue());
////                        if (val.getKey().equals("Разъем наушники/микрофон"))
////                            connectors.setHeadph_microph(val.getKey() + " -> " + val.getValue());
//                        if (val.getKey().equals("Разъемов DisplayPort"))
//                            connectors.setDisplayPort(val.getKey() + " -> " + val.getValue());
//                        if (val.getKey().equals("Разъемов USB 3.1"))
//                            connectors.setUSB_31(val.getKey() + " -> " + val.getValue());
//                        if (val.getKey().equals("Разъемов USB 3.0 (Type-C)"))
//                            connectors.setUSB_30TypeC(val.getKey() + " -> " + val.getValue());
//                        if (val.getKey().equals("Разъемов DVI"))
//                            connectors.setDVI(val.getKey() + " -> " + val.getValue());
//                    }
//                    connectorsRepo.save(connectors);
//                    break;
//                case ("Программное обеспечение"):
//                    OS os = new OS();
//                    os.setID(id);
//                    for (Map.Entry<String, String> val : value.entrySet()) {
//                        if (val.getKey().equals("Операционная система"))
//                            os.setOS_name(val.getKey() + " -> " + val.getValue());
//                        if (val.getKey().equals("Разрядность ОС"))
//                            os.setOS_capacity(val.getKey() + " -> " + val.getValue());
//                    }
//                    osRepo.save(os);
//                    break;
//                case ("Процессор"):
//                    CPU cpu = new CPU();
//                    cpu.setID(id);
//                    for (Map.Entry<String, String> val : value.entrySet()) {
//                        if (val.getKey().equals("Сокет процессора"))
//                            cpu.setCPU_socket(val.getKey() + " -> " + val.getValue());
//                        if (val.getKey().equals("Процессор")||val.getKey().equals("Модель процессора"))
//                            cpu.setCPU_model(val.getKey() + " -> " + val.getValue());
//                        if (val.getKey().equals("Процессор, частота")||val.getKey().equals("Частота процессора"))
//                            cpu.setCPU_frequency(val.getKey() + " -> " + val.getValue());
//                        if (val.getKey().equals("Количество ядер процессора"))
//                            cpu.setCPU_cores(val.getKey() + " -> " + val.getValue());
//                        if (val.getKey().equals("Чипсет материнской платы"))
//                            cpu.setCPU_chipset(val.getKey() + " -> " + val.getValue());
//                    }
//                    cpuRepo.save(cpu);
//                    break;
//                case (""):
//                    GeneralInformation generalInformation = new GeneralInformation();
//                    generalInformation.setID(id);
//                    for (Map.Entry<String, String> val : value.entrySet()) {
//                        if (val.getKey().equals("Гарантия"))
//                            generalInformation.setWarranty(val.getKey() + " -> " + val.getValue());
//                        if (val.getKey().equals("Сайт производителя"))
//                            generalInformation.setProducts_webpage(val.getKey() + " -> " + val.getValue());
//                        if (val.getKey().equals("Страна производитель"))
//                            generalInformation.setCountry_manufacture(val.getKey() + " -> " + val.getValue());
//                    }
//                    generalInformationRepo.save(generalInformation);
//                    break;
//            }
//
//        }
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
