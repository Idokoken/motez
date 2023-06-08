import React from "react";
import styled from "styled-components";
import { Link, NavLink } from "react-router-dom";

const Wrapper = styled.div`
  font-family: "Roboto", sans-serif;

  .bg-light {
    background-color: var(--secondary-color) !important;
    box-shadow: 5px 5px 10px 5px #eee6e6;
  }
  .navbar-brand {
    margin-bottom: 4px !important;
    font-weight: 700;
    color: var(--primary-color);
  }

  .nav-link {
    color: var(--primary-color);
    font-weight: 600;
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
              src="/images/brand.png"
              alt=""
              width="30"
              height="30"
              className="d-inline-block align-text-top"
              style={{ borderRadius: "50%", marginRight: "10px" }}
            />
            motez
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
                <NavLink className="nav-link" to="/admin">
                  Admin
                </NavLink>
              </li>
              <li className="nav-item">
                <NavLink className="nav-link" to="/login">
                  signin
                </NavLink>
              </li>
              <li className="nav-item">
                <NavLink className="nav-link" to="/register">
                  signup
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
