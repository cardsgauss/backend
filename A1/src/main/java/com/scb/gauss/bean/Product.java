package com.scb.gauss.bean;

public class Product {
private  int id;
private  String name;
private  String prod_type;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getProd_type() {
	return prod_type;
}
public void setProd_type(String prod_type) {
	this.prod_type = prod_type;
}
public Product(int id, String name, String prod_type) {
	super();
	this.id = id;
	this.name = name;
	this.prod_type = prod_type;
}
public Product() {
	super();
}


}
