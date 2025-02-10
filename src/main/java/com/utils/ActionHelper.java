package com.utils;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author Abhishek Kadavil
 */
@Slf4j
public class ActionHelper {

    public void scrollByVisibilityOfElementWebDriver(WebDriver driver, WebElement ele) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", ele);
    }

    public void clickAction(WebDriver driver, WebElement ele) {
        Actions act = new Actions(driver);
        act.moveToElement(ele).click().build().perform();
    }

    public boolean findElement(WebElement ele) {
        boolean flag = false;
        try {
            ele.isDisplayed();
            flag = true;
        } catch (Exception e) {
            log.info("*** Error occurred ***\n {}", String.valueOf(e));
        } finally {
            if (flag) {
                log.info("Successfully Found element {}", ele);
            } else {
                log.info("Unable to locate element {}", ele);
            }
        }
        return flag;
    }

    public boolean isDisplayed(WebElement ele) {
        boolean flag = false;
        flag = findElement(ele);
        if (flag) {
            flag = ele.isDisplayed();
            if (flag) {
                log.info("The element is Displayed {}", ele);
            } else {
                log.info("The element is not Displayed {}", ele);
            }
        } else {
            log.info("Not displayed {}", ele);
        }
        return flag;
    }

    public boolean isSelected(WebElement ele) {
        boolean flag = false;
        flag = findElement(ele);
        if (flag) {
            flag = ele.isSelected();
            if (flag) {
                log.info("The element is Selected {}", ele);
            } else {
                log.info("The element is not Selected {}", ele);
            }
        } else {
            log.info("Not selected {}", ele);
        }
        return flag;
    }

    public boolean isEnabled(WebElement ele) {
        boolean flag = false;
        flag = findElement(ele);
        if (flag) {
            flag = ele.isEnabled();
            if (flag) {
                log.info("The element is Enabled {}", ele);
            } else {
                log.info("The element is not Enabled {}", ele);
            }
        } else {
            log.info("Not Enabled {}", ele);
        }
        return flag;
    }

    public boolean mouseHoverByJavaScript(WebElement ele, WebDriver driver) {
        boolean flag = false;
        try {
            String javaScript = "var evObj = document.createEvent('MouseEvents');"
                    + "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
                    + "arguments[0].dispatchEvent(evObj);";
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(javaScript, ele);
            flag = true;
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                log.info("MouseOver Action is performed {}", ele);
            } else {
                log.info("MouseOver Action is not performed {}", ele);
            }
        }
    }

    public boolean jsClick(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", ele);

            flag = true;

        } catch (Exception e) {
            log.error(e.toString());
            throw e;
        } finally {
            if (flag) {
                log.info("Click Action is performed {}", ele);
            } else {
                log.info("Click Action is not performed {}", ele);
            }
        }
        return flag;
    }

    public boolean switchToFrameById(WebDriver driver, String idValue) {
        boolean flag = false;
        try {
            driver.switchTo().frame(idValue);
            flag = true;
        } catch (Exception e) {
            log.error(e.toString());
            throw e;
        } finally {
            if (flag) {
                log.info("Frame with Id \"{}\" is selected", idValue);
            } else {
                log.info("Frame with Id \"{}\" is not selected", idValue);
            }
        }
        return flag;
    }

    public boolean switchToFrameByName(WebDriver driver, String nameValue) {
        boolean flag = false;
        try {
            driver.switchTo().frame(nameValue);
            flag = true;
        } catch (Exception e) {
            log.error(e.toString());
            throw e;
        } finally {
            if (flag) {
                log.info("Frame with Name \"{}\" is selected", nameValue);
            } else {
                log.info("Frame with Name \"{}\" is not selected", nameValue);
            }
        }
        return flag;
    }

    public boolean switchToDefaultFrame(WebDriver driver) {
        boolean flag = false;
        try {
            driver.switchTo().defaultContent();
            flag = true;
        } catch (Exception e) {
            log.error(e.toString());
            throw e;
        } finally {
            if (flag) {
                log.info("Switch to default frame");
            } else {
                log.info("Switch to default frame failed");
            }
        }
        return flag;
    }

    public void mouseOverElement(WebDriver driver, WebElement element) {
        boolean flag = false;
        try {
            new Actions(driver).moveToElement(element).build().perform();
            flag = true;
        } catch (Exception e) {
            log.error(e.toString());
            throw e;
        } finally {
            if (flag) {
                log.info("MouserOver Action is performed on {}", element);
            } else {
                log.info("MouseOver action is not performed on {}", element);
            }
        }
    }

    public boolean moveToElement(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].scrollIntoView(true);", ele);
            Actions actions = new Actions(driver);
            actions.moveToElement(ele).build().perform();
            flag = true;
        } catch (Exception e) {
            log.error(e.toString());
            throw e;
        }
        return flag;
    }

    public boolean mouseover(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            new Actions(driver).moveToElement(ele).build().perform();
            flag = true;
        } catch (Exception e) {
            log.error(e.toString());
            throw e;
        }
        return flag;
    }

    public boolean draggable(WebDriver driver, WebElement source, int x, int y) throws InterruptedException {
        boolean flag = false;
        try {
            new Actions(driver).dragAndDropBy(source, x, y).build().perform();
            Thread.sleep(5000);
            flag = true;
        } catch (Exception e) {
            log.error(e.toString());
            throw e;
        } finally {
            if (flag) {
                log.info("Draggable Action is performed on \"{}\"", source);
            } else {
                log.info("Draggable action is not performed on \"{}\"", source);
            }
        }
        return flag;
    }

    public boolean dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
        boolean flag = false;
        try {
            new Actions(driver).dragAndDrop(source, target).perform();
            flag = true;
        } catch (Exception e) {
            log.error(e.toString());
            throw e;
        } finally {
            if (flag) {
                log.info("DragAndDrop action is performed");
            } else {
                log.info("DragAndDrop action is not performed");
            }
        }
        return flag;
    }

    public boolean slider(WebDriver driver, WebElement ele, int x, int y) throws InterruptedException {
        boolean flag = false;
        try {
            new Actions(driver).dragAndDropBy(ele, x, y).build().perform();// 150,0
            Thread.sleep(5000);
            flag = true;
        } catch (Exception e) {
            log.error(e.toString());
            throw e;
        } finally {
            if (flag) {
                log.info("Slider Action is performed {}", ele);
            } else {
                log.info("Slider Action is not performed {}", ele);
            }
        }
        return flag;
    }

    public boolean rightClick(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            Actions clicker = new Actions(driver);
            clicker.contextClick(ele).perform();
            flag = true;
        } catch (Exception e) {
            log.error(e.toString());
            throw e;
        } finally {
            if (flag) {
                log.info("RightClick Action is performed {}", ele);
            } else {
                log.info("RightClick Action is not performed {}", ele);
            }
        }
        return flag;
    }

    public boolean switchWindowByTitle(WebDriver driver, String windowTitle, int count) {
        boolean flag = false;
        try {
            Set<String> windowList = driver.getWindowHandles();

            String[] array = windowList.toArray(new String[0]);

            driver.switchTo().window(array[count - 1]);

            flag = Objects.requireNonNull(driver.getTitle()).contains(windowTitle);
        } catch (Exception e) {
            log.error(e.toString());
            throw e;
        } finally {
            if (flag) {
                log.info("Navigated to the window with title");
            } else {
                log.info("The window with title is not selected");
            }
        }
        return flag;
    }

    public boolean switchToNewWindow(WebDriver driver) {
        boolean flag = false;
        try {

            Set<String> s = driver.getWindowHandles();
            Object[] popup = s.toArray();
            driver.switchTo().window(popup[1].toString());
            flag = true;
        } catch (Exception e) {
            log.error(e.toString());
            throw e;
        } finally {
            if (flag) {
                log.info("Window is Navigated with title");
            } else {
                log.info("The Window with title is not selected");
            }
        }
        return flag;
    }

    public boolean switchToOldWindow(WebDriver driver) {
        boolean flag = false;
        try {

            Set<String> s = driver.getWindowHandles();
            Object[] popup = s.toArray();
            driver.switchTo().window(popup[0].toString());
            flag = true;
        } catch (Exception e) {
            log.error(e.toString());
            throw e;
        } finally {
            if (flag) {
                log.info("Focus navigated to the window with title");
            } else {
                log.info("The Window with title: is not Selected");
            }
        }
        return flag;
    }

    public int getColumnCount(WebElement row) {
        List<WebElement> columns = row.findElements(By.tagName("td"));
        int a = columns.size();
        log.info(String.valueOf(columns.size()));
        for (WebElement column : columns) {
            log.info(column.getText());
            log.info("|");
        }
        return a;
    }

    public int getRowCount(WebElement table) {
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        return rows.size() - 1;
    }


    /**
     * Verify alert present or not
     *
     * @return: Boolean (True: If alert preset, False: If no alert)
     */
    public boolean alert(WebDriver driver) {
        boolean presentFlag = false;
        Alert alert = null;

        try {
            // Check the presence of alert
            alert = driver.switchTo().alert();
            // if present consume the alert
            alert.accept();
            presentFlag = true;
        } catch (NoAlertPresentException ex) {
            log.error(ex.toString());
            throw ex;
        } finally {
            if (!presentFlag) {
                log.info("The alert is handled successfully");
            } else {
                log.info("There was no alert to handle");
            }
        }

        return presentFlag;
    }

    public boolean launchUrl(WebDriver driver, String url) {
        boolean flag = false;
        try {
            driver.navigate().to(url);
            flag = true;
        } catch (Exception e) {
            log.error(e.toString());
            throw e;
        } finally {
            if (flag) {
                log.info("Successfully launched \"" + url + "\"");
            } else {
                log.info("Failed to launch \"" + url + "\"");
            }
        }
        return flag;
    }

    public boolean isAlertPresent(WebDriver driver) {
        boolean flag = false;
        try {
            driver.switchTo().alert();
            flag = true;
        }
        catch (NoAlertPresentException ex) {
            log.error(ex.toString());
            throw ex;
        }
        return flag;
    }
}
