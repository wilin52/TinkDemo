package com.wilin.tinkdemo.main.cityGuide.mode;

import com.wilin.tinkdemo.main.cityGuide.CityGuideType;

import java.io.Serializable;

/**
 * Created by Lin WenLong on 2018/6/2.
 *
 * data for displaying the guide of city
 */
public class CityGuideBean implements Serializable{
    /**
     * type of item which displayed.
     */
    private @CityGuideType int guideType;
    /**
     * the url of image,both kind of item have.
     */
    private String imageUrl;
    /**
     * only CityGuideType.DESCRIPTION has
     */
    private String descriptionTitle;
    /**
     * only CityGuideType.DESCRIPTION has
     */
    private String descriptionDetail;

    public int getGuideType() {
        return guideType;
    }

    public void setGuideType(int guideType) {
        this.guideType = guideType;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescriptionTitle() {
        return descriptionTitle;
    }

    public void setDescriptionTitle(String descriptionTitle) {
        this.descriptionTitle = descriptionTitle;
    }

    public String getDescriptionDetail() {
        return descriptionDetail;
    }

    public void setDescriptionDetail(String descriptionDetail) {
        this.descriptionDetail = descriptionDetail;
    }
}
