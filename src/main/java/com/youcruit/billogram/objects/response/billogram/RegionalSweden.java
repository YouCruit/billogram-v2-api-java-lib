package com.youcruit.billogram.objects.response.billogram;

import com.google.gson.annotations.Expose;

public class RegionalSweden {

    @Expose
    private Boolean rotavdrag;

    
    public Boolean getRotavdrag() {
	return rotavdrag;
    }

    
    public void setRotavdrag(Boolean rotavdrag) {
	this.rotavdrag = rotavdrag;
    }

    public RegionalSweden withRotavdrag(Boolean rotavdrag) {
	this.rotavdrag = rotavdrag;
	return this;
    }

}
