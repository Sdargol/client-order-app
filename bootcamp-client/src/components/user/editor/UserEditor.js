import { useState } from "react";
import { useParams } from "react-router-dom";
import { useFetch } from "../../../hooks/http/useFetch";
import { FetchError } from "../../app/error/FetchError";
import { OrderCard } from "./card/OrderCard";
import { InputField } from "./input/InputField";
import './UserEditor.css';

export const UserEditor = () => {
    const { login } = useParams('login');
    const url = `http://localhost:8080/api/v1/clients/${login}`;
    
    const header = {
        method: "GET",
        headers: { 'Content-Type': 'application/json;charset=utf-8' },
    };

    let [userName, setUserName] = useState({name:''});
    
    let { res, err } = useFetch(url,header, setUserName);

    const handlerInputUserName = (e) => {
        setUserName({...userName, name:e.target.value});
    }

    // можно потом поправить 
    if(err){
        return <FetchError/>
    }

    return (
        <div className="App User-editor-container">
            <h1>UserEditor</h1>
            <InputField val = {userName.name} handler = {handlerInputUserName} name = "Имя пользователя"/>
            <div className="User-editor-orders-container">
                {res ? res.orders.map((obj, i) => <OrderCard key = {i} id = {obj.id} info = {obj.info}></OrderCard>) : ""}
            </div> 
        </div>
    )
}