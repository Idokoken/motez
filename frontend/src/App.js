import { Route, Routes, BrowserRouter as Router } from "react-router-dom";
import Home from "./pages/Home";
import Contact from "./pages/Contact";
import About from "./pages/About";
import Header from "./components/Header";
import Footer from "./components/Footer";
import ErrorPage from "./components/ErrorPage";
import RegisterPage from "./pages/RegisterPage";
import LoginPage from "./pages/LoginPage";
import CartPage from "./pages/CartPage";
import Products from "./components/Products";
import SingleProduct from "./components/SingleProduct";
import AdminDashboard from "./admin/AdminDashboard";
import AddUsers from "./admin/user/AddUsers";
import EditUser from "./admin/user/EditUser";
import UserDashboard from "./admin/user/UserDashboard";

function App() {
  return (
    <Router>
      <Header />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<About />} />
        <Route path="/contact" element={<Contact />} />
        <Route path="/products" element={<Products />} />
        <Route path="/product/:id" element={<SingleProduct />} />
        <Route path="/cart" element={<CartPage />} />

        <Route path="/admin" element={<AdminDashboard />} />
        <Route path="/user/create" element={<AddUsers />} />
        <Route path="/user/edit/:id" element={<EditUser />} />
        <Route path="/user/:id" element={<UserDashboard />} />

        <Route path="/register" element={<RegisterPage />} />
        <Route path="/login" element={<LoginPage />} />

        <Route path="*" element={<ErrorPage />} />
      </Routes>
      <Footer />
    </Router>
  );
}

export default App;
