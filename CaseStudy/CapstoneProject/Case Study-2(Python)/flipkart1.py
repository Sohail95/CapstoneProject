import time
import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By

@pytest.fixture(scope="module")
def browser():
    driver = webdriver.Chrome()
    driver.maximize_window()
    yield driver
    driver.quit()
def test_flipkart_login(browser):
    url ="https://www.flipkart.com/"
    browser.get(url)

    browser.find_element(By.XPATH, "//button[@class='_2KpZ6l _2doB4z']").click()

    # Click on login button
    browser.find_element(By.XPATH, "//a[normalize-space()='Login']").click()

    # Enter Phone number & click on Request OTP button
    browser.find_element(By.XPATH, "//input[@class='_2IX_2- VJZDxU']").send_keys("9705574502")
    browser.find_element(By.XPATH, "//button[normalize-space()='Request OTP']").click()
    time.sleep(3)

    # Verify that able to see popup message
    message = browser.find_element(By.XPATH, "//div[normalize-space()='Please enter the OTP sent to']")
    if (message):
        print("Pop up message is verified Sucessfully")
    else:
        print("Pop up message is not verified")