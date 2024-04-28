import './css/App.css';
import {Fragment, useEffect, useState} from "react";
import data from './data.js';
import {Routes, Route, Link, useNavigate, Outlet} from 'react-router-dom'
import Detail from "./routes/Detail";
import axios from "axios";
import {faCartShopping, faHeart, faMagnifyingGlass, faUser} from "@fortawesome/free-solid-svg-icons";

import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";




function App() {

    let [shoes,setShoes] = useState(data)
    let navigate = useNavigate();
    let [product, setProduct] = useState("");

    useEffect(() => {
        axios.get("/product/list")
            .then((resp) => {
                setProduct(resp.data);
                console.log(product);
            }).catch(() => {
            console.log("실패");
        })
    }, []);

  return (
      <div className="App">
            <Header/>


          <Routes>
              <Route path="*" element={<div>없는 페이지입니다</div>}/>
              <Route path="/" element={
                  <Fragment>

                  <div className="container">
                      <div className="row">
                          {product && product.map((product, index) => {
                              return (
                                  <Product product={product} key={index}></Product>
                              )
                          })}
                      </div>
                  </div>


                  </Fragment>

              }/>


          </Routes>


      </div>
  );
}

function Product(props){
    return (
        <div className="col-md-4">
           <img src={props.product.productImage} width="80%"/>
            <h5>{props.product.productName}</h5>
            <p>{props.product.productPrice}</p>
        </div>
    )
}

function Header(){
    const navigate = useNavigate();
    return(
        <div className="header">
            <div className="main-bg"></div>
            <div className="header-search">
                <div className="inner">
                    <h1 className="site-name" onClick={() => {navigate('/')}}>
                        LIKELY
                    </h1>
                    <form className="form-search">
                        <div className="search-outer">
                            <input type="search" className="input-search"/>
                            <button type="submit" className="btn-search">
                                <FontAwesomeIcon icon={faMagnifyingGlass} size="2x"/>
                            </button>
                        </div>
                    </form>
                    <nav className="header-icon">
                        <button className="btn-icon">
                            <FontAwesomeIcon icon={faCartShopping} size="2x"/>
                        </button>
                        <button className="btn-icon">
                            <FontAwesomeIcon icon={faHeart} size="2x" />
                        </button>
                        <button className="btn-icon">
                            <FontAwesomeIcon icon={faUser} size="2x" />
                        </button>
                    </nav>
                </div>
            </div>


            <div className="Navbar-menu">
                <a onClick={()=> {navigate('/')}} className="tab-menu">홈</a>
                <a onClick={()=> {navigate('/detail')}} className="tab-menu">카테고리</a>
                <a onClick={()=> {navigate('/detail')}} className="tab-menu">패션직구</a>
                <a onClick={()=> {navigate('/detail')}} className="tab-menu">하루배송</a>
                <a onClick={()=> {navigate('/detail')}} className="tab-menu">베스트</a>
                <a onClick={()=> {navigate('/detail')}} className="tab-menu">세일</a>
                <a onClick={()=> {navigate('/detail')}} className="tab-menu">이벤트</a>
                <a onClick={()=> {navigate('/detail')}} className="tab-menu">신상</a>
            </div>


        </div>
    )
}








export default App;
