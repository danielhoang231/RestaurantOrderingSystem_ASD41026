import React, { useState } from 'react';

const CheckoutPage = () => {
  const [paymentMethod, setPaymentMethod] = useState('CreditCard');
  const [customerName, setCustomerName] = useState('John Doe');
  const [couponCode, setCouponCode] = useState('');
  const [discount, setDiscount] = useState(0);

  const [cartItems, setCartItems] = useState([
    { id: 1, name: 'Margherita Pizza', price: 15.99, quantity: 2 },
    { id: 2, name: 'Caesar Salad', price: 10.99, quantity: 1 },
    { id: 3, name: 'Lemonade', price: 4.50, quantity: 3 }
  ]);

  const validCoupons = {
    'DISCOUNT10': 10,
    'DISCOUNT20': 20,
  };

  const handlePaymentMethodChange = (e) => {
    setPaymentMethod(e.target.value);
  };

  const calculateTotal = () => {
    const total = cartItems.reduce((acc, item) => acc + item.price * item.quantity, 0);
    return (total - (total * (discount / 100))).toFixed(2);
  };

  const applyCoupon = () => {
    if (validCoupons[couponCode]) {
      setDiscount(validCoupons[couponCode]);
      alert(`Coupon applied! You got ${validCoupons[couponCode]}% off.`);
    } else {
      alert('Invalid coupon code.');
      setDiscount(0);
    }
  };

  const handlePlaceOrder = () => {
    alert('Order placed successfully!');
  };

  return (
    <div className="checkout-page">
      <h1>Order Checkout</h1>
      <div className="checkout-container">
        <div className="customer-info">
          <h2>Customer: {customerName}</h2>
        </div>

        <div className="cart-summary">
          <h2>Your Order</h2>
          {cartItems.map(item => (
            <div key={item.id} className="cart-item">
              <span>{item.name} x {item.quantity}</span>
              <span>${(item.price * item.quantity).toFixed(2)}</span>
            </div>
          ))}
          <div className="cart-total">
            <strong>Total: </strong> ${calculateTotal()}
          </div>
        </div>

        <div className="coupon-section">
          <h2>Coupon Code</h2>
          <input 
            type="text" 
            value={couponCode} 
            onChange={(e) => setCouponCode(e.target.value)} 
            placeholder="Enter coupon code"
          />
          <button onClick={applyCoupon} className="apply-coupon-button">Apply Coupon</button>
        </div>

        <div className="checkout-details">
          <h2>Payment Method</h2>
          <div className="payment-method">
            <label>
              <input 
                type="radio" 
                value="CreditCard" 
                checked={paymentMethod === 'CreditCard'} 
                onChange={handlePaymentMethodChange} 
              />
              Credit Card
            </label>
            <label>
              <input 
                type="radio" 
                value="PayPal" 
                checked={paymentMethod === 'PayPal'} 
                onChange={handlePaymentMethodChange} 
              />
              PayPal
            </label>
          </div>

          <button onClick={handlePlaceOrder} className="place-order-button">
            Confirm Order
          </button>
        </div>
      </div>
    </div>
  );
};

export default CheckoutPage;
