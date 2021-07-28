import { useState } from "react";
import { useParams } from "react-router-dom";
import { useFetch } from "../../../hooks/http/useFetch";
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

    return (
        <div className="App User-editor-container">
            <h1>UserEditor</h1>
            <div className="User-editor-input-container">
                <label className="User-editor-input-label" htmlFor="username-input-id">Имя пользователя</label>
                <input onChange={handlerInputUserName}
                    id="username-input-id"
                    className="User-editor-input"
                    type="input"
                    placeholder="Username..."
                    autoComplete="off"
                    aria-label="New user name"
                    value={userName.name}></input>
            </div>
        </div>
    )
}