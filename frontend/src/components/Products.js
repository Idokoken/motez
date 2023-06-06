import React, { useState, useEffect } from "react";
import styled from "styled-components";
import { Link } from "react-router-dom";
import { Tablet, Desktop } from "../Responsive";

const Wrapper = styled.div`
  margin: 0;
  padding: 0;

  .product-container {
    display: grid;
    grid-template-columns: 50% 50%;
    gap: 10px;
    padding: 20px;
    ${Tablet({ gridTemplateColumns: "25% 25% 25% 25%" })}
    ${Desktop({ gridTemplateColumns: "16% 16% 16% 16% 16% 16%" })}
  }

  .product {
    height: 250px;
    padding: 10px;
    box-shadow: 5px 5px 5px 2px #888888;
  }

  .img-container {
    width: 100%;
    height: 55%;
    background-color: grey;

    margin: auto;
  }
  img {
    height: 100%;
    width: 100%;
  }
  h4 {
    font-family: Georgia, "Times New Roman", Times, serif;
    font-size: 16px;
    margin-top: 10px;
    font-weight: 600;
  }
  p {
    font-size: 10px;
    font-weight: 600;
  }
  .rating {
    display: flex;
    margin-top: 10px;
  }
  .rate {
    font-size: 8px;
    color: rgba(200, 80, 12, 1);
    margin-right: 5px;
  }
`;

function Products() {
  const [products, setProducts] = useState([]);

  const getProducts = async () => {
    try {
      const resp = await fetch("/product");
      const data = await resp.json();
      setProducts(data);
      console.log(data);
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    getProducts();
  }, []);

  const items = products.map((item, i) => (
    <div className="product" key={item._id}>
      <Link
        style={{ textDecoration: "none", color: "inherit" }}
        to={`/product/${item._id}`}
      >
        <div className="img-container">
          <img src={item.image} alt="product cover" width="100" height="100" />
        </div>
        <h4>{item.name}</h4>
        <div className="rating">
          <div className="rate">
            <i className="fa fa-star"></i>
            <i className="fa fa-star"></i>
            <i className="fa fa-star"></i>
            <i className="fa fa-star-half-stroke"></i>
            <i className="fa-regular fa-star"></i>
          </div>
          <p>{item.numOfReviews} Reviews</p>
        </div>
        <div className="price">
          <p>${item.price}</p>
          <span></span>
        </div>
      </Link>
    </div>
  ));

  return (
    <Wrapper>
      <div className="product-container">{items}</div>
    </Wrapper>
  );
}

export default Products;
