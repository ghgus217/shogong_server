package com.shogong.sgs.vo;

public class BusinessProductUpdateVo {

    int idx;
    String userId;
    String productTitle;
    int productPrice;
    int productAddFee;
    String productBody;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductAddFee() {
        return productAddFee;
    }

    public void setProductAddFee(int productAddFee) {
        this.productAddFee = productAddFee;
    }

    public String getProductBody() {
        return productBody;
    }

    public void setProductBody(String productBody) {
        this.productBody = productBody;
    }
}