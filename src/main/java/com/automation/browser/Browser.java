package com.automation.browser;

import org.openqa.selenium.WebDriver;

public abstract class Browser {

    private boolean isHeadless;
    private boolean isRemote;
    private boolean isMaximized;
    private Integer pageLoadTimeout;
    private boolean deleteCookies;

    public abstract void setPreferences();
    public abstract WebDriver loadBrowser(String path);
    public boolean isHeadless() {
        return isHeadless;
    }
    public void setHeadless(boolean headless) {
        isHeadless = headless;
    }
    public boolean isRemote() {
        return isRemote;
    }
    public void setRemote(boolean remote) {
        isRemote = remote;
    }
    public boolean isMaximized() {
        return isMaximized;
    }
    public void setMaximized(boolean maximized) {
        isMaximized = maximized;
    }
    public Integer getPageLoadTimeout() {
        return pageLoadTimeout;
    }
    public void setPageLoadTimeout(Integer pageLoadTimeout) {
        this.pageLoadTimeout = pageLoadTimeout;
    }
    public boolean isDeleteCookies() {
        return deleteCookies;
    }
    public void setDeleteCookies(boolean deleteCookies) {
        this.deleteCookies = deleteCookies;
    }
}
