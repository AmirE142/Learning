from selenium import webdriver

browser = webdriver.Firefox(executable_path= 'C:\Drivers\geckodriver.exe') #starting a selenium webdriver to pop up a real Firefox
browser.get('http://localhost:8000')
browser.close
assert 'Django' in browser.title