import { render, screen, fireEvent } from '@testing-library/react';
import CheckoutPage from './CheckoutPage';

test('renders CheckoutPage with cart items', () => {
  render(<CheckoutPage />);

  // Check for customer name
  const customerName = screen.getByText(/customer: john doe/i);
  expect(customerName).toBeInTheDocument();

  // Check for cart items
  const pizzaItem = screen.getByText(/margherita pizza/i);
  const saladItem = screen.getByText(/caesar salad/i);
  expect(pizzaItem).toBeInTheDocument();
  expect(saladItem).toBeInTheDocument();
});

test('applies coupon and calculates total', () => {
  render(<CheckoutPage />);

  // Check initial total
  const initialTotal = screen.getByText(/total: \$56\.47/i);
  expect(initialTotal).toBeInTheDocument();

  // Enter and apply coupon
  const couponInput = screen.getByPlaceholderText(/enter coupon code/i);
  fireEvent.change(couponInput, { target: { value: 'DISCOUNT10' } });
  const applyCouponButton = screen.getByText(/apply coupon/i);
  fireEvent.click(applyCouponButton);

  // Check updated total after discount
  const discountedTotal = screen.getByText(/total: \$50\.82/i);
  expect(discountedTotal).toBeInTheDocument();
});

test('submits order on Confirm Order', () => {
  render(<CheckoutPage />);

  // Simulate placing an order
  const confirmOrderButton = screen.getByText(/confirm order/i);
  fireEvent.click(confirmOrderButton);

  // Check for alert or any action that confirms the order
  expect(window.alert).toHaveBeenCalledWith('Order placed successfully!');
});
