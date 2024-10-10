import { render, screen } from '@testing-library/react';
import { BrowserRouter } from 'react-router-dom';
import App from './App';

test('renders Checkout and Order History links', () => {
  render(
    <BrowserRouter>
      <App />
    </BrowserRouter>
  );

  // Check for the links
  const checkoutLink = screen.getByText(/checkout/i);
  const orderHistoryLink = screen.getByText(/order history/i);

  // Ensure they are in the document
  expect(checkoutLink).toBeInTheDocument();
  expect(orderHistoryLink).toBeInTheDocument();
});

test('navigates to CheckoutPage', () => {
  render(
    <BrowserRouter>
      <App />
    </BrowserRouter>
  );

  // Click the checkout link
  const checkoutLink = screen.getByText(/checkout/i);
  checkoutLink.click();

  // Check for content in CheckoutPage
  const checkoutHeading = screen.getByText(/order checkout/i);
  expect(checkoutHeading).toBeInTheDocument();
});

test('navigates to OrderHistoryPage', () => {
  render(
    <BrowserRouter>
      <App />
    </BrowserRouter>
  );

  // Click the order history link
  const orderHistoryLink = screen.getByText(/order history/i);
  orderHistoryLink.click();

  // Check for content in OrderHistoryPage
  const orderHistoryHeading = screen.getByText(/order history/i);
  expect(orderHistoryHeading).toBeInTheDocument();
});
