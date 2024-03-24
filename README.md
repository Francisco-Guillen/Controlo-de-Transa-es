# Databse Transaction Control

## Description

This project is based on three applications that interact with the database when carrying out transactions.
There will be an _Edit application_ that will allow the user to edit the quantity of each product or the customer's address; a _Browser application_ that will allow orders and their lines to be visualised; a _Log application_ that will show the records of type EventType='**O**' in a grid and, finally.

The database implemented in this project was built using the integrated _SQL ServerManagement Studio_ (SSMS) environment, which made it possible to carry out all the necessary operations and execute the scirpts, and consists of three tables: **Order**, **OrderLine** and **LogOperations**. 
In this case, the level of normalisation of the relationships is not relevant.
- **Order** (EncID, CustomerId, Name,Address)
- **OrderLine** (EncID, ProductId, Name, Price, Qty)
- **LogOperations** (NumReg, EventTye,Object, Value, Reference,UserId, TerminalId, TerminalName, DCreation)

## Edit Application
In this application, the user can change the details of an order after selecting the ID of the order they wish to change from the list of orders.

<p align="center">
<img src="https://github.com/Francisco-Guillen/Database-Transaction-Control/assets/83434031/5155a979-b706-469b-9fe1-54a1dc5cd665">
<br>
  Figure 1: List of orders.
</p>

You are then redirected to a new page that includes all the orders with the ID you selected earlier. On this page, assuming that the user does not want to edit the products in the order, it is possible to change the address and/or quantity of the product ordered, as mentioned in the statement.
After pressing the save button, a transaction is initiated in which the order data is read and presented to the user. The changes are made and accepted, and finally, after the transition is completed, a record is written to the logs.

## Browser Application
This module allows users to visualise orders and lines.
It has a window with two grids where you can visualise the order and the products associated with it. The data is sorted in descending order by order number. This window also has a button to reload the data if the user wants to see the updated data, which is very useful as it can lead to wrong decisions.

<p align="center">
<img src="https://github.com/Francisco-Guillen/Database-Transaction-Control/assets/83434031/a628c85b-65c0-408a-9571-4a988746a968">
<br>
  Figure 1: Browser Application.
</p>

## Log Application

For this case, an application was developed consisting of a window where the user can see a grid with the first N most recent lines of the LogOperations table.

<p align="center">
<img src="https://github.com/Francisco-Guillen/Database-Transaction-Control/assets/83434031/0e6e2ff4-0808-4676-987b-eea87b274182">
<br>
  Figure 1: Log Application.
</p>



