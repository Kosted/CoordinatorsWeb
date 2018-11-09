package helperClasses.match;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

public class MatchHeader {

    private String metchId;
    private  String matchCulture;
    private  String mainProperty;
    private  String matchDate;
    private  String matchRadius;
    private  String status;

    private  WebElement statusButton;

//    private  String headerPartsClassName;
//    private  List<WebElement> headerpartsList;


    public String getMetchId() {
        return metchId;
    }

    public String getMatchCulture() {
        return matchCulture;
    }

    public String getMainProperty() {
        return mainProperty;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public String getMatchRadius() {
        return matchRadius;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "\nMatchHeader{" +
                "\nmetchId='" + metchId + '\'' +
                ", \nmatchCulture='" + matchCulture + '\'' +
                ", \nmainProperty='" + mainProperty + '\'' +
                ", \nmatchDate='" + matchDate + '\'' +
                ", \nmatchRadius='" + matchRadius + '\'' +
                ", \nstatus='" + status + '\'' +
                '}';
    }

    public MatchHeader(WebElement matchHeader) {

//        headerPartsClassName = "f1e9c6";
//
//        headerpartsList = matchHeader.findElements(By.className(headerPartsClassName));
//
//        //metchId = headerpartsList.get(0).getText();
//        matchCulture = headerpartsList.get(1).getText();
//        matchDate = headerpartsList.get(2).getText();
//        matchRadius = headerpartsList.get(3).getText().replaceAll("[^0-9,\\.]+", "");
//
        statusButton = matchHeader.findElement(By.tagName("button"));
        status = statusButton.getText();



        List<WebElement> descriptionList = matchHeader.findElements(By.className("c03fc2"));
        List<WebElement> valueList = matchHeader.findElements(By.className("f1e9c6"));

        for (int descriptionsIterator = 0; descriptionsIterator < descriptionList.size(); descriptionsIterator++)
            switch (descriptionList.get(descriptionsIterator).getText()) {
                case "ID Мэтча": {
                    metchId = valueList.get(descriptionsIterator).getText();
                    break;
                }
                case "Культура": {
                    matchCulture = valueList.get(descriptionsIterator).getText();
                    break;
                }
                case "Дата появления Мэтча": {
                    matchDate = valueList.get(descriptionsIterator).getText().replaceAll("[^0-9,\\.]+", "");
                    break;
                }
                case "Удаленность": {
                    matchRadius = valueList.get(descriptionsIterator).getText();
                    break;
                }
                default: {
                    mainProperty = valueList.get(descriptionsIterator).getText().replaceAll("[^0-9,\\.]+", "");
                    break;
                }
            }
    }

    public WebElement getStatusButton() {
        return statusButton;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MatchHeader)) return false;
        MatchHeader that = (MatchHeader) o;
        return Objects.equals(getMetchId(), that.getMetchId()) &&
                Objects.equals(getMatchCulture(), that.getMatchCulture()) &&
                Objects.equals(getMainProperty(), that.getMainProperty()) &&
                Objects.equals(getMatchDate(), that.getMatchDate()) &&
                Objects.equals(getMatchRadius(), that.getMatchRadius()) &&
                Objects.equals(getStatus(), that.getStatus());
    }

}
