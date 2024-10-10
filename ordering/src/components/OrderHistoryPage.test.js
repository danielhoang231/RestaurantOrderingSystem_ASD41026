import { render, screen, fireEvent } from '@testing-library/react';
import OrderHistoryPage from './OrderHistoryPage';

test('renders order history', () => {
  render(<OrderHistoryPage />);

  // Check that order history items are rendered
  const order1 = screen.getByText(/order #101/i);
  const order2 = screen.getByText(/order #102/i);
  expect(order1).toBeInTheDocument();
  expect(order2).toBeInTheDocument();

  // Check for individual order items
  const pizzaItem = screen.getByText(/pepperoni pizza/i);
  const friesItem = screen.getByText(/fries/i);
  expect(pizzaItem).toBeInTheDocument();
  expect(friesItem).toBeInTheDocument();
});

test('reorders items from order history', () => {
  render(<OrderHistoryPage />);

  // Click the reorder button for an order
  const reorderButton = screen.getAllByText(/reorder/i)[0];
  fireEvent.click(reorderButton);

  // Check for alert or any action related to reordering
  expect(window.alert).toHaveBeenCalledWith('Reordered items from Order #101');
});
