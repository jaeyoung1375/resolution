import React, {Fragment, useEffect, useState} from "react";
import {useParams} from "react-router-dom";
// import styled from "styled-components";
//
// let YellowBtn = styled.button`
//   background-color: ${props => props.bg};
//   color : ${props => props.bg == 'blue' ? 'white' : 'black'} ;
//   padding: 10px;
// `
// let NewBtn = styled.button(YellowBtn)`
//
// `




function Detail(props){
    let [count,setCount] = useState(0);
    let {id} = useParams();
    let result = props.shoes.find((x) => x.id == id);
    let  [visible, setVisible] = useState(true);
    let [num,setNum] = useState("");


    useEffect(() => {
        // 서버에서 데이터를 가져오는 작업
        //let a = setTimeout(() => {setVisible(false)},2000);
        // return ()=>{
        //     clearTimeout(a);
        // }
        if(isNaN(num) == true){
            alert("ㄴㄴ");
        }


    }, [num]);



    return(
        <Fragment>
            <div className="container">
                {/*{*/}
                {/*    visible == true ? <Alert/> : null*/}
                {/*}*/}

                {count}
                <button onClick={()=> {setCount(count+1) }}>버튼</button>
                <div className="row">
                    <div className="col-md-6">
                        <img src={result.img} width="80%" />
                    </div>
                    <div className="col-md-6">

                        <input type="text" onChange={ (e) => {setNum(e.target.value)}}/>

                        <h4 className="pt-5">{result.title}</h4>
                        <p>{result.content}</p>
                        <p>{result.price}원</p>
                        <button className="btn btn-danger">주문하기</button>
                    </div>
                </div>
            </div>
        </Fragment>
    )
}

function Alert(){
    return(
        <Fragment>
            <div className="alert alert-warning">
                2초이내 구매시 할인
            </div>
        </Fragment>
    )
}


export default Detail;