package com.waverley.utils;

import lombok.experimental.UtilityClass;
import one.util.streamex.StreamEx;
import org.openqa.selenium.WebElement;

import java.util.List;

@UtilityClass
public final class ElementTypeUtils {

    public static <T> WebElement elementOf(final T element){
        return(WebElement)element;
    }
    @SuppressWarnings("unchecked")
    public static <T> List<WebElement> listof(final T element){
        return (List<WebElement>) element;
    }
    public static <T> StreamEx<WebElement> streamof(final T element){
        return StreamEx.of(listof(element));
    }

}
