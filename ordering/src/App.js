import React from 'react';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import CheckoutPage from './components/CheckoutPage';  // Assuming you moved it to the components folder
import OrderHistoryPage from './components/OrderHistoryPage';  // Assuming you moved it to the components folder
import './App.css';

function App() {
  return (
    <Router>
      <div className="App">
        <header className="App-header">
          <h1>Restaurant Ordering System</h1>
          <nav className="nav-links">
            <Link to="/checkout">Checkout</Link>
            <Link to="/history">Order History</Link>
          </nav>
        </header>

        {/* Separate Routes for each page */}
        <Routes>
          {/* Route for CheckoutPage */}
          <Route path="/checkout" element={<CheckoutPage />} />
          {/* Route for OrderHistoryPage */}
          <Route path="/history" element={<OrderHistoryPage />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;


