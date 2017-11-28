package com.waverley;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.function.BiFunction;
import java.util.function.Function;

@Getter
public enum WaitCondition {
    visible(ExpectedConditions::visibilityOfElementLocated),
    present(ExpectedConditions::presenceOfElementLocated),
    //enabled(ExpectedConditions::elementToBeClickable),
    allvisible(ExpectedConditions::visibilityOfAllElementsLocatedBy),
    textpresent(ExpectedConditions::textToBePresentInElementLocated),
    textpresentinvalue(ExpectedConditions::textToBePresentInElementValue);
    private BiFunction<By, String, ExpectedCondition<?>> type;

    private WaitCondition(Function<By, ExpectedCondition<?>> type) {
        this((locator, text) -> type.apply(locator));
    }

    private WaitCondition(BiFunction<By, String, ExpectedCondition<?>> type) {
        this.type = type;
    }
}


