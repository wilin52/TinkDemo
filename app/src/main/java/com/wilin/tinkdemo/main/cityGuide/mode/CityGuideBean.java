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
    private @CityGuideType int type;
    /**
     * the url of image,both kind of item have.
     */
    private String imageSrc;
    /**
     * only CityGuideType.DESCRIPTION has
     */
    private String descriptionTitle;
    /**
     * only CityGuideType.DESCRIPTION has
     */
    private String description;

    public @CityGuideType int getType() {
        return type;
    }

    public void setType(@CityGuideType int type) {
        this.type = type;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getDescriptionTitle() {
        return descriptionTitle;
    }

    public void setDescriptionTitle(String descriptionTitle) {
        this.descriptionTitle = descriptionTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
