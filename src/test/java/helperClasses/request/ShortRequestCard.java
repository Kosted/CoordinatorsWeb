package helperClasses.request;

import helperClasses.WebActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

public class ShortRequestCard {


    private String culture;
    private String mainProperty;
    private String volume;
    private String range;
    private String priceWithoutLogistic;
    private String date;
    private String id;
    private String user;
    private String phoneNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShortRequestCard that = (ShortRequestCard) o;
        return Objects.equals(culture, that.culture) &&
                Objects.equals(mainProperty, that.mainProperty) &&
                Objects.equals(volume, that.volume) &&
                Objects.equals(priceWithoutLogistic, that.priceWithoutLogistic) &&
                Objects.equals(date, that.date) &&
                Objects.equals(id, that.id) &&
                Objects.equals(user, that.user) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(company, that.company) &&
                Objects.equals(inn, that.inn) &&
                Objects.equals(nds, that.nds) &&
                Objects.equals(actual, that.actual) &&
                Objects.equals(actualDays, that.actualDays);
    }

    public String getActual() {
        return actual;
    }

    public String getActualDays() {
        return actualDays;
    }

    private String company;
    private String inn;
    private String nds;

    private String actual;
    private String price;
    private String actualDays;

    private int contentSize;

    public ShortRequestCard(WebElement requestCard) {

        if (requestCard.findElements(By.className("c662c6")).size() == 1) {
            price = requestCard.findElements(By.className("c662c6")).get(0).getText();
        } else price = null;


        culture = requestCard.findElement(By.className("_11c481")).getText();

        List<WebElement> webElements = requestCard.findElements(By.className("_3111bc"));

        int listIterator = 0;
        mainProperty = webElements.get(listIterator++).getText();
        volume = webElements.get(listIterator++).getText().replaceAll("[^0-9,\\.]+", "");

        //if (price != null) {
        range = webElements.get(listIterator++).getText().replaceAll("[^0-9,\\.]+", "");
        //} else range = null;

        priceWithoutLogistic = webElements.get(listIterator++).getText().replaceAll("[^0-9,\\.]+", "");
        date = webElements.get(listIterator++).getText().replaceAll("[^0-9,\\.]+", "");
        id = webElements.get(listIterator++).getText().replaceAll("[^0-9,\\.]+", "");

        webElements = requestCard.findElements(By.tagName("p"));

        user = webElements.get(0).getText();
        phoneNumber = webElements.get(1).getText();
        company = webElements.get(2).getText();
        inn = webElements.get(3).getText();
        nds = webElements.get(4).getText();

        webElements = requestCard.findElement(By.className("_02b587")).findElements(By.tagName("span"));

        actual = webElements.get(0).getText();
        actualDays = webElements.get(1).getText();

        contentSize = requestCard.findElements(By.className("_02b587")).size(); //актуальность
        contentSize += requestCard.findElements(By.className("d2f99e")).size(); //влажность, объём, удалеленность, без логистики, дата создания, id
        contentSize += requestCard.findElements(By.className("_11c481")).size();// культура
        contentSize += requestCard.findElements(By.className("a0ca95")).size(); // цена с логистикой

    }

    public ShortRequestCard(WebElement requestCard, WebActions web_a) {

//        String[] fieldsName = new String[5];
//        fieldsName[0] = "Объем";
//        fieldsName[1] = "Удаленность";
//        fieldsName[2] = "Без логистики";
//        fieldsName[3] = "Дата создания";
//        fieldsName[4] = "ID";
        //fieldsName[6] = "Пользователь";
        //fieldsName[7] = "Компания";

        WebElement cultureWebElem = web_a.isPresent(requestCard, By.className("_11c481"), 2);
        if (cultureWebElem == null) {
            culture = null;
        } else {
            culture = cultureWebElem.getText();
        }

        WebElement simplProperty = requestCard.findElement(By.className("_541c00"));
        List<WebElement> descriptionList = simplProperty.findElements(By.className("d2f99e"));
        List<WebElement> valueList = simplProperty.findElements(By.className("_3111bc"));


        //определение основного свойства
//        int fieldsNameIt = 0;
//
//        String currentField = descriptionList.get(descriptionsIterator).getText();
//
//        while (!currentField.equals(fieldsName[fieldsNameIt]) && fieldsNameIt < fieldsName.length) {
//            fieldsNameIt++;
//        }
//        if (currentField.equals(fieldsName[fieldsNameIt])) {
//            mainProperty = null;
//        } else {
//            mainProperty = valueList.get(descriptionsIterator++).getText();
//        }
        //

        //определение других свойств

        for (int descriptionsIterator = 0; descriptionsIterator < descriptionList.size(); descriptionsIterator++)
            switch (descriptionList.get(descriptionsIterator).getText()) {
                case "Объем": {
                    volume = valueList.get(descriptionsIterator).getText().replaceAll("[^0-9,\\.]+", "");
                    break;
                }
                case "Удаленность": {
                    range = valueList.get(descriptionsIterator).getText().replaceAll("[^0-9,\\.]+", "");
                    break;
                }
                case "Без логистики": {
                    priceWithoutLogistic = valueList.get(descriptionsIterator).getText().replaceAll("[^0-9,\\.]+", "");
                    break;
                }
                case "Дата создания": {
                    date = valueList.get(descriptionsIterator).getText();
                    break;
                }
                case "ID": {
                    id = valueList.get(descriptionsIterator).getText().replaceAll("[^0-9,\\.]+", "");
                    break;
                }
                default: {
                    mainProperty = valueList.get(descriptionsIterator).getText().replaceAll("[^0-9,\\.]+", "");
                    break;
                }
            }

        List<WebElement> webElements = requestCard.findElements(By.tagName("p"));
        int size = webElements.size();
        int webElemIt = 0;
        if (size > webElemIt++) {
            user = webElements.get(0).getText();
            if (size > webElemIt++) {
                phoneNumber = webElements.get(1).getText();
                if (size > webElemIt++) {
                    company = webElements.get(2).getText();
                    if (size > webElemIt++) {
                        inn = webElements.get(3).getText();
                        if (size > webElemIt++) {
                            nds = webElements.get(4).getText();
                        }
                    }
                }
            }
        }

        webElements = requestCard.findElement(By.className("_02b587")).findElements(By.tagName("span"));

        webElemIt = 0;
        size = webElements.size();
        if (size > webElemIt++)
            actualDays = webElements.get(1).getText();
        if (size > webElemIt++)
            actual = webElements.get(0).getText();

        if (web_a.isPresent(requestCard, By.className("c662c6"), 0) != null)
            price = requestCard.findElement(By.className("c662c6")).getText();

        contentSize = requestCard.findElements(By.className("_02b587")).size(); //актуальность
        contentSize += requestCard.findElements(By.className("d2f99e")).size(); //влажность, объём, удалеленность, без логистики, дата создания, id
        contentSize += requestCard.findElements(By.className("_11c481")).size();// культура
        contentSize += requestCard.findElements(By.className("a0ca95")).size(); // цена с логистикой
    }

    public int getContentSize() {
        return contentSize;
    }

    public String getCulture() {
        return culture;
    }

    public String getMainProperty() {
        return mainProperty;
    }

    public String getVolume() {
        return volume;
    }

    public String getPrice() {
        return price;
    }

    public String getRange() {
        return range;
    }

    public String getPriceWithoutLogistic() {
        return priceWithoutLogistic;
    }

    public String getDate() {
        return date;
    }

    public String getId() {
        return id;
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

    @Override
    public String toString() {
        return "ShortRequestCard{" +
                "\nculture='" + culture + '\'' +
                ", \nmainProperty='" + mainProperty + '\'' +
                ", \nvolume='" + volume + '\'' +
                ", \nrange='" + range + '\'' +
                ", \npriceWithoutLogistic='" + priceWithoutLogistic + '\'' +
                ", \ndate='" + date + '\'' +
                ", \nid='" + id + '\'' +
                ", \nuser='" + user + '\'' +
                ", \nphoneNumber='" + phoneNumber + '\'' +
                ", \ncompany='" + company + '\'' +
                ", \ninn='" + inn + '\'' +
                ", \nnds='" + nds + '\'' +
                ", \nactual='" + actual + '\'' +
                ", \nprice='" + price + '\'' +
                ", \nactualDays='" + actualDays + '\'' +
                ", \ncontentSize=" + contentSize +
                '}';
    }
}
