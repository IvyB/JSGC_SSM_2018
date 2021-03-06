package util.com.jsgc.searchCondition;

import java.text.ParseException;

public class DocumentSearchConditions {
    String order;//解析一下
    String realOrder;
    String descOrNot;
    private String documentSerial;
    private String documentName;
    private String documentType;
    private String documentOwner;
    private String docUploadTimeRange;
    String docUploadTimeMin;
    String docUploadTimeMax;
    private int start;
    private int page;
    private int limit;

    //  lzq,可访问范围
    private String userLevel;
    private String userID;

    @Override
    public String toString() {
        return "DocumentSearchConditions{" +
                "order='" + order + '\'' +
                ", realOrder='" + realOrder + '\'' +
                ", descOrNot='" + descOrNot + '\'' +
                ", documentSerial='" + documentSerial + '\'' +
                ", documentName='" + documentName + '\'' +
                ", documentType='" + documentType + '\'' +
                ", documentOwner='" + documentOwner + '\'' +
                ", docUploadTimeRange='" + docUploadTimeRange + '\'' +
                ", docUploadTimeMin='" + docUploadTimeMin + '\'' +
                ", docUploadTimeMax='" + docUploadTimeMax + '\'' +
                ", start=" + start +
                ", page=" + page +
                ", limit=" + limit +
                ", userLevel='" + userLevel + '\'' +
                ", userID='" + userID + '\'' +
                '}';
    }

    public String getDocUploadTimeMin() {
        return docUploadTimeMin;
    }

    public void setDocUploadTimeMin(String docUploadTimeMin) {
        this.docUploadTimeMin = docUploadTimeMin;
    }

    public String getDocUploadTimeMax() {
        return docUploadTimeMax;
    }

    public void setDocUploadTimeMax(String docUploadTimeMax) {
        this.docUploadTimeMax = docUploadTimeMax;
    }

    public void parseUserID(){
        if(!userLevel.equals("2")) this.userID=null;
    }
    public String getUserLevel() {
        return userLevel;
    }
    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public void parseDateRange() throws ParseException {
        if(this.docUploadTimeRange!=null&&!this.docUploadTimeRange.equals("")){
            this.docUploadTimeMin= this.docUploadTimeRange.substring(0,10);
            this.docUploadTimeMax=this.docUploadTimeRange.substring(13,23);
        }
    }
    public void parseOrder(){
        if(this.order!=null&&!this.order.equals("[]")){
            String[]ss=this.order.split(",");
            String []former= ss[0].split(":");
            String []later=ss[1].split(":");
            int column=Integer.parseInt(former[1]);
            this.descOrNot=later[1].substring(1,later[1].length()-3);
            switch (column){
                case 5:
                    this.realOrder="documentUploadTime";
                    break;
            }
        }
    }


    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getRealOrder() {
        return realOrder;
    }

    public void setRealOrder(String realOrder) {
        this.realOrder = realOrder;
    }

    public String getDescOrNot() {
        return descOrNot;
    }

    public void setDescOrNot(String descOrNot) {
        this.descOrNot = descOrNot;
    }

    public String getDocumentSerial() {
        return documentSerial;
    }

    public void setDocumentSerial(String documentSerial) {
        this.documentSerial = documentSerial;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentOwner() {
        return documentOwner;
    }

    public void setDocumentOwner(String documentOwner) {
        this.documentOwner = documentOwner;
    }

    public String getDocUploadTimeRange() {
        return docUploadTimeRange;
    }

    public void setDocUploadTimeRange(String docUploadTimeRange) {
        this.docUploadTimeRange = docUploadTimeRange;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
