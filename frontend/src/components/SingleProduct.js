import React, { useState, useEffect } from "react";
import styled from "styled-components";
import { useParams } from "react-router-dom";
import { Tablet } from "../Responsive";

const Wrapper = styled.div`
  padding: 0;
  margin: 0;

  .product {
    min-height: 70vh;
    display: flex;
    flex-direction: column;
    padding: 20px;
    ${Tablet({ flexDirection: "column" })}
  }
  .img-container,
  .content {
    flex: 100%;
    /* ${Tablet({ flexDirection: "column" })} */
  }
  .img-container {
    width: 500px;
    height: 600px;
  }
  img {
    width: 100%;
    height: 100%;
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

function SingleProduct() {
  const [product, setProduct] = useState({});
  const { id } = useParams();

  const getProduct = async () => {
    try {
      const resp = await fetch(`/product/${id}`);
      const data = await resp.json();
      setProduct(data);
      console.log(data);
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    getProduct();
  }, [id]);

  return (
    <Wrapper>
      <div className="product">
        <div className="img-container">
          <img src={product.image} alt={product.name} />
        </div>
        <div className="content">
          <h3>{product.name}</h3>
          <p className="price">${product.price}</p>
          <div className="rating">
            <div className="rate">
              <i className="fa fa-star"></i>
              <i className="fa fa-star"></i>
              <i className="fa fa-star"></i>
              <i className="fa fa-star-half-stroke"></i>
              <i className="fa-regular fa-star"></i>
            </div>
            <p>{product.numOfReviews} Reviews</p>
          </div>
        </div>
      </div>
      <div className="related">
        <h4>related products</h4>
        <div>the products</div>
      </div>
    </Wrapper>
  );
}

export default SingleProduct;
