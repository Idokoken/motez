import React from "react";
import styled from "styled-components";
import { Link, NavLink } from "react-router-dom";

const Wrapper = styled.div`
  .navbar-brand {
    margin-bottom: 4px !important;
    font-weight: 700;
    font-family: "Times New Roman", Times, serif;
  }
  .nav-link:active {
    background-color: #50a !important;
  }
`;

function Header() {
  return (
    <Wrapper>
      <nav className="navbar navbar-expand-sm navbar-light bg-light">
        <div className="container-fluid">
          <button
            className="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarTogglerDemo03"
            aria-controls="navbarTogglerDemo03"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span className="navbar-toggler-icon"></span>
          </button>
          <Link className="navbar-brand" to="/">
            <img
              src="/assets/brand.png"
              alt=""
              width="30"
              height="30"
              className="d-inline-block align-text-top"
              style={{ borderRadius: "50%" }}
            />
            chimi
          </Link>
          <div className="collapse navbar-collapse" id="navbarTogglerDemo03">
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
              <li className="nav-item">
                <NavLink className="nav-link" to="/products">
                  Products
                </NavLink>
              </li>
              <li className="nav-item">
                <NavLink className="nav-link" to="/cart">
                  ShoopingCart
                </NavLink>
              </li>
            </ul>
            <ul className="navbar-nav ms-auto mb-2 mb-lg-0">
              <li className="nav-item">
                <NavLink className="nav-link" to="/login">
                  Sign In
                </NavLink>
              </li>
              <li className="nav-item">
                <NavLink className="nav-link" to="/register">
                  Sign Up
                </NavLink>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </Wrapper>
  );
}

export default Header;
