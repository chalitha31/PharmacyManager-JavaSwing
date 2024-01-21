package model;

public class InvoiceReport {

  
    private String cashier;
    private String customer;
    private String product;
    private String p_no;
    private String qty;
    private String price;
    private String amount;
    private String total;
    private String payment_by;
    private String payment;
    private String balance;


    public InvoiceReport(String cashier, String customer, String product, String p_no, String qty, String price, String amount, String total, String payment_by, String payment, String balance) {
     
        this.cashier = cashier;
        this.customer = customer;
        this.product = product;
        this.p_no = p_no;
        this.qty = qty;
        this.price = price;
        this.amount = amount;
        this.total = total;
        this.payment_by = payment_by;
        this.payment = payment;
        this.balance = balance;
     
    }
    
    



    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getP_no() {
        return p_no;
    }

    public void setP_no(String p_no) {
        this.p_no = p_no;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getPayment_by() {
        return payment_by;
    }

    public void setPayment_by(String payment_by) {
        this.payment_by = payment_by;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

}
