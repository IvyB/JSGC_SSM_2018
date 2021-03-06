package util.com.jsgc.searchCondition;

public class AssetSearchConditions {
    String order;//解析一下
    String realOrder;
    String descOrNot;
    private String assetName;
    private String assetDate;
    private String departmentName;
    private String projectSerial;
    private String projectName;
    private String projectStatus;
    private String assetStatus;


    public String getAssetStatus() {
        return assetStatus;
    }

    public void setAssetStatus(String assetStatus) {
        this.assetStatus = assetStatus;
    }

    private int start;
    private int page;
    private int limit;

    //  lzq,可访问范围
    private String userLevel;
    private String userID;

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

    @Override
    public String toString() {
        return "AssetSearchConditions{" +
                "order='" + order + '\'' +
                ", realOrder='" + realOrder + '\'' +
                ", descOrNot='" + descOrNot + '\'' +
                ", assetName='" + assetName + '\'' +
                ", assetDate='" + assetDate + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", projectSerial='" + projectSerial + '\'' +
                ", projectName='" + projectName + '\'' +
                ", projectStatus='" + projectStatus + '\'' +
                ", assetStatus='" + assetStatus + '\'' +
                ", start=" + start +
                ", page=" + page +
                ", limit=" + limit +
                ", userLevel='" + userLevel + '\'' +
                ", userID='" + userID + '\'' +
                '}';
    }

    public void parseOrder(){
        if(this.order!=null&&!this.order.equals("[]")){
            String[]ss=this.order.split(",");
            String []former= ss[0].split(":");
            String []later=ss[1].split(":");
            int column=Integer.parseInt(former[1]);
            this.descOrNot=later[1].substring(1,later[1].length()-3);
            switch (column){
                case 4:
                    this.realOrder="assetAmount";
                    break;
                case 5:
                    this.realOrder="assetMoney";
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

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetDate() {
        return assetDate;
    }

    public void setAssetDate(String assetDate) {
        this.assetDate = assetDate;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getProjectSerial() {
        return projectSerial;
    }

    public void setProjectSerial(String projectSerial) {
        this.projectSerial = projectSerial;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
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
