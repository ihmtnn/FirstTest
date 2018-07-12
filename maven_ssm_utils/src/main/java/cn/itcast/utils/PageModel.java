package cn.itcast.utils;

import java.util.List;

public class PageModel {

    //基本属性
    private Integer currentPageNum;     //当前页，由用户提交参数来指定，如果没有指定可以有默认值
    private Integer pageSize;           //每页要展示的条数，也由用户来指定，如果没有指定可以有默认值
    private Integer totalCountRecords;  //所要展示的总条数，数据库查出来的
    private Integer totalPageNum;       //总页数，通过查询的总条数，计算出来的
    private Integer startIndex;         //每页开始记录的索引，计算出来的
    private Integer endIndex;           //每页结束的索引，计算出来的
    private Integer prePageNum;         //上一页
    private Integer nextPageNum;        //下一页

    private List records;               //已经分好页的结果集，该List中只有当前页pageSize条记录

    //扩展属性
    //每页显示9个页码按钮,就是说每个页面上只有9个页码可以选择(这个需要根据jsp页面来进行选择)
    //上一页 1 2 3 4 5 6 7 8 9 下一页 尾页
    private Integer startPage;  //起始页
    private Integer endPage;    //结束页

    //完善属性
    private String url;



    /**
     *  构造函数
     *  要想使用我的分布，必须给我两个参数，一个是当前页（就是你想查看哪一页），另一个是总记录条数，还一个每页数据的条数
     *  要清楚一点,PageModel只携带一个页面的数据,其它的先不管
     */
    public PageModel(Integer currentPageNum, Integer totalCountRecords, Integer pageSize) {
        this.currentPageNum = currentPageNum;
        this.totalCountRecords = totalCountRecords;
        this.pageSize = pageSize;

        //计算查询记录的开始索引,就是说当前页面的第一条记录在数据库中的索引位置
        startIndex = (currentPageNum - 1)*pageSize;
        endIndex = currentPageNum*pageSize;

        //计算总页数
        totalPageNum = totalCountRecords%pageSize == 0?(totalCountRecords/pageSize):(totalCountRecords/pageSize+1);

        startPage = currentPageNum - 2;
        endPage = currentPageNum + 2;

        //判断总页数够不够5页
        if (totalCountRecords > 5){
            //如果超过了5页
            //开始分析两头,因为两头就只能是第一页或者是总页数
            if (startPage < 1){
                startPage = 1;
                endPage = startPage + 4;
            }
            if (endPage > totalPageNum){
                endPage = totalPageNum;
                startPage = endPage - 4;
            }
        }else{
            //如果不够5页,就很简单了，起始页就是第一页，最后一页就是总页数
            startPage = 1;
            endPage = totalPageNum;
        }
    }

    public Integer getCurrentPageNum() {
        return currentPageNum;
    }

    public void setCurrentPageNum(Integer currentPageNum) {
        this.currentPageNum = currentPageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCountRecords() {
        return totalCountRecords;
    }

    public void setTotalCountRecords(Integer totalCountRecords) {
        this.totalCountRecords = totalCountRecords;
    }

    public Integer getTotalPageNum() {
        return totalPageNum;
    }

    public void setTotalPageNum(Integer totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(Integer endIndex) {
        this.endIndex = endIndex;
    }

    public Integer getPrePageNum() {
        prePageNum = currentPageNum - 1;
        if (prePageNum < 1){
            prePageNum = 1;
        }
        return prePageNum;
    }

    public void setPrePageNum(Integer prePageNum) {
        this.prePageNum = prePageNum;
    }

    public Integer getNextPageNum() {
        nextPageNum = currentPageNum + 1;
        if (nextPageNum > totalPageNum){
            nextPageNum = totalPageNum;
        }
        return nextPageNum;
    }

    public void setNextPageNum(Integer nextPageNum) {
        this.nextPageNum = nextPageNum;
    }

    public List getRecords() {
        return records;
    }

    public void setRecords(List records) {
        this.records = records;
    }

    public Integer getStartPage() {
        return startPage;
    }

    public void setStartPage(Integer startPage) {
        this.startPage = startPage;
    }

    public Integer getEndPage() {
        return endPage;
    }

    public void setEndPage(Integer endPage) {
        this.endPage = endPage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
