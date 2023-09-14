import React from "react";
import styled from "styled-components";
import { Link } from "react-router-dom";
import { Tablet } from "../Responsive";

const Wrapper = styled.div`
  margin: 0;
  padding: 30px;
  background: var(--background-color);
  color: var(--secondary-color);

  .items {
    display: grid;
    grid-template-columns: 100%;
    ${Tablet({ gridTemplateColumns: "25% 25% 25% 25%" })}
  }
  .link {
    margin: 15px 0;
  }
  a {
    text-decoration: none;
    color: rgba(255, 255, 255, 0.5);
  }
`;

function Footer() {
  return (
    <Wrapper>
      <div className="items">
        <div className="item">
          <h4>Company</h4>
          <div className="link">
            <Link to="/">about us</Link>
          </div>
          <div className="link">
            <Link to="/">contact us</Link>
          </div>
          <div className="link">
            <Link to="/">policy </Link>
          </div>
          <div className="link">
            <Link to="/">Products</Link>
          </div>
        </div>
        <div className="item">
          <h4>Company</h4>
          <div className="link">
            <Link to="/">about us</Link>
          </div>
          <div className="link">
            <Link to="/">contact us</Link>
          </div>
          <div className="link">
            <Link to="/">policy </Link>
          </div>
          <div className="link">
            <Link to="/">Products</Link>
          </div>
        </div>
        <div className="item">
          <h4>Company</h4>
          <div className="link">
            <Link to="/">about us</Link>
          </div>
          <div className="link">
            <Link to="/">contact us</Link>
          </div>
          <div className="link">
            <Link to="/">policy </Link>
          </div>
          <div className="link">
            <Link to="/">Products</Link>
          </div>
        </div>
        <div className="item">
          <h4>Company</h4>
          <div className="link">
            <Link to="/">about us</Link>
          </div>
          <div className="link">
            <Link to="/">contact us</Link>
          </div>
          <div className="link">
            <Link to="/">policy </Link>
          </div>
          <div className="link">
            <Link to="/">Products</Link>
          </div>
        </div>
      </div>
    </Wrapper>
  );
}

export default Footer;
