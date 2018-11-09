package helperClasses.request;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class FullRequestCard {


    private String culture;
    private String id;
    private String volume;

    private String price;
    private String priceWithLogistic;
    private String range;
    private String[] propertes;
    private String addres;
    private String logisticIsPossible;
    private String logisticPrice;
    private String logisticRadius;
    private String priseCondition;
    private String date;
    private String user;
    private String phoneNumber;

    private String company;
    private String inn;
    private String nds;


    private int contentSize;

    public FullRequestCard(WebElement requestCard) {

        // получение культуры и id
        String header = requestCard.findElement(By.xpath("//*[contains(@class, '_5f4c35')]")).getText();

        //вычленение культуры
        int headerSize = header.length();
        int i = 0;
        culture = "";
        while (headerSize > i && header.charAt(i) != '(') {
            culture += header.charAt(i);
            i++;
        }
        //вычленение id
        id = header.substring(i).replaceAll("[^0-9,\\.]+", "");

        List<WebElement> valueList = requestCard.findElements(By.className("_97058b"));
        List<WebElement> descriptionList = requestCard.findElements(By.className("_624ef2"));
////////////////////////////
        logisticIsPossible = "";
        String temp;

        for (int descriptionsIterator = 0; descriptionsIterator < descriptionList.size(); descriptionsIterator++)
            switch (descriptionList.get(descriptionsIterator).getText()) {
                case "Объем": {
                    volume = valueList.get(descriptionsIterator).getText().replaceAll("[^0-9,\\.]+", "");
                    break;
                }
                case "Цена": {
                    price = valueList.get(descriptionsIterator).getText().replaceAll("[^0-9,\\.]+", "");
                    break;
                }
                case "Цена с логистикой": {
                    temp = valueList.get(descriptionsIterator).getText();
                    i = 0;
                    priceWithLogistic = "";
                    while (temp.length() > i && temp.charAt(i) != '(') {
                        priceWithLogistic += temp.charAt(i);
                        i++;
                    }
                    priceWithLogistic = priceWithLogistic.replaceAll("[^0-9,\\.]+", "");
                    //удаленность
                   // if (temp.length() != i)
                        range = temp.substring(i).replaceAll("[^0-9]+", "");
                    break;
                }
                case "Параметры культуры": {
                    List<WebElement> propertesList = valueList.get(descriptionsIterator).findElements(By.tagName("p"));
                    propertes = new String[propertesList.size()];
                    for (i = 0; i < propertesList.size(); i++)
                        propertes[i] = propertesList.get(i).getText();
                    break;
                }
                case "Адрес": {
                    addres = valueList.get(descriptionsIterator).getText();
                    break;
                }
                case "Доставка": {
                    logisticIsPossible = valueList.get(descriptionsIterator).getText();
                    break;
                }
                case "Стоимость логистики": {
                    logisticPrice = valueList.get(descriptionsIterator).getText().replaceAll("[^0-9,\\.]+", "");
                    break;
                }
                case "Радиус логистики": {
                    logisticRadius = valueList.get(descriptionsIterator).getText().replaceAll("[^0-9,\\.]+", "");
                    break;
                }
                case "Условия оплаты": {
                    priseCondition = valueList.get(descriptionsIterator).getText();
                    break;
                }
                case "Дата публикации": {
                    date = valueList.get(descriptionsIterator).getText();
                    break;
                }
                case "Пользователь": {
                    // вычленение фио юзера
                    temp = valueList.get(descriptionsIterator).getText();
                    i = 0;
                    user = "";
                    while (temp.charAt(i) != ',') {
                        user += temp.charAt(i++);
                    }

                    // мобильный телефон
                    phoneNumber = temp.substring(++i);
                    break;
                }
                case "Компания": {
                    temp = valueList.get(descriptionsIterator).getText();
                    i = 0;
                    company = "";
                    while (temp.charAt(i) != ',') {
                        company += temp.charAt(i++);
                    }
                    i++;

                    // вычленение ИНН
                    inn = "";
                    while (temp.charAt(i) != ',') {
                        inn += temp.charAt(i++);
                    }
                    inn = inn.replaceAll("[^0-9,\\.]+", "");

                    // НДС
                    nds = temp.substring(++i);
                    break;
                }

            }


//////////////////////////
//        // объём
//        volume = valueList.get(listIterator++).getText().replaceAll("[^0-9,\\.]+", "");
//
//        // цена
//        price = valueList.get(listIterator++).getText().replaceAll("[^0-9,\\.]+", "");
//
//        // цена с логистикой
//        String temp = valueList.get(listIterator++).getText();
//        i = 0;
//        priceWithLogistic = "";
//        while (temp.length() > i && temp.charAt(i) != '(') {
//            priceWithLogistic += temp.charAt(i);
//            i++;
//        }
//
//        priceWithLogistic = priceWithLogistic.replaceAll("[^0-9,\\.]+", "");
//
//        // удаленность
//        if (temp.length() != i)
//            range = temp.substring(i).replaceAll("[^0-9]+", "");
//        else range = null;
//
//        // свойства
//        List<WebElement> propertesList = valueList.get(listIterator++).findElements(By.tagName("p"));
//        propertes = new String[propertesList.size()];
//        for (i = 0; i < propertesList.size(); i++) {
//            propertes[i] = propertesList.get(i).getText();
//        }
//        //адрес
//        addres = valueList.get(listIterator++).getText();
//
//        //возможность доставки
//        if (valueList.size() == 12)
//            logisticIsPossible = valueList.get(listIterator++).getText();
//        else logisticIsPossible = null;
//
//        //цена логистики
//        logisticPrice = valueList.get(listIterator++).getText().replaceAll("[^0-9,\\.]+", "");
//
//        //радиус логистики
//        logisticRadius = valueList.get(listIterator++).getText().replaceAll("[^0-9,\\.]+", "");
//
//        // условия оплаты
//        priseCondition = valueList.get(listIterator++).getText();
//
//        //дата
//        date = valueList.get(listIterator++).getText();
//
//        // вычленение фио юзера
//        temp = valueList.get(listIterator++).getText();
//        i = 0;
//        user = "";
//        while (temp.charAt(i) != ',') {
//            user += temp.charAt(i++);
//        }
//
//        // мобильный телефон
//        phoneNumber = temp.substring(++i);
//
//        // вычленение названия компании
//        temp = valueList.get(listIterator++).getText();
//        i = 0;
//        company = "";
//        while (temp.charAt(i) != ',') {
//            company += temp.charAt(i++);
//        }
//        i++;
//
//        // вычленение ИНН
//        inn = "";
//        while (temp.charAt(i) != ',') {
//            inn += temp.charAt(i++);
//        }
//        inn = inn.replaceAll("[^0-9,\\.]+", "");
//
//        // НДС
//        nds = temp.substring(++i);

        contentSize = requestCard.findElements(By.className("_624ef2")).size();// объём, цена, цена с логистикой, параметры культуры, адрес, достава, стоимость логистики, радиус логистики, условия олаты, дата публикации, пользователь, компания
        contentSize += requestCard.findElements(By.xpath("//*[contains(@class, '_5f4c35')]")).size(); //культура и id

    }

    public int getContentSize() {
        return contentSize;
    }

    @Override
    public String toString() {
        return "FullRequestCard{" +
                "\nculture='" + culture + '\'' +
                ", \nid='" + id + '\'' +
                ", \nvolume='" + volume + '\'' +
                ", \nprice='" + price + '\'' +
                ", \npriceWithLogistic='" + priceWithLogistic + '\'' +
                ", \nrange='" + range + '\'' +
                ", \npropertes=" + Arrays.toString(propertes) +
                ", \naddres='" + addres + '\'' +
                ", \nlogisticIsPossible='" + logisticIsPossible + '\'' +
                ", \nlogisticPrice='" + logisticPrice + '\'' +
                ", \nlogisticRadius='" + logisticRadius + '\'' +
                ", \npriseCondition='" + priseCondition + '\'' +
                ", \ndate='" + date + '\'' +
                ", \nuser='" + user + '\'' +
                ", \nphoneNumber='" + phoneNumber + '\'' +
                ", \ncompany='" + company + '\'' +
                ", \ninn='" + inn + '\'' +
                ", \nnds='" + nds + '\'' +
                ", \ncontentSize=" + contentSize +
                '}';
    }

    public String getCulture() {
        return culture;
    }

    public String getId() {
        return id;
    }

    public String getVolume() {
        return volume;
    }

    public String getPrice() {
        return price;
    }

    public String getPriceWithLogistic() {
        return priceWithLogistic;
    }

    public String getRange() {
        return range;
    }

    public String[] getPropertes() {
        return propertes;
    }

    public String getAddres() {
        return addres;
    }

    public String getLogisticIsPossible() {
        return logisticIsPossible;
    }

    public String getLogisticPrice() {
        return logisticPrice;
    }

    public String getLogisticRadius() {
        return logisticRadius;
    }

    public String getPriseCondition() {
        return priseCondition;
    }

    public String getDate() {
        return date;
    }

    public String getUser() {
        return user;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCompany() {
        return company;
    }

    public String getInn() {
        return inn;
    }

    public String getNds() {
        return nds;
    }
}
