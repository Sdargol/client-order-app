import { useFetch } from '../../hooks/http/useFetch';
import { Card } from '../app/card/Card';
import { FetchError } from '../app/error/FetchError';
import '../../App.css';
import { createClient } from '../../http_api/clients/clientApi';
import { createOrder } from '../../http_api/orders/orderApi';

export const Users = () => {
    const host = 'http://localhost:8080/api/v1/clients';

    const header = {
      method: "GET",
      headers: {
        'Content-Type': 'application/json;charset=utf-8'
      },
    };
  
    const { res, err } = useFetch(host, header);
  
    return (
      <div className="App">
        <header className="App-header">
          <h1>Список пользователей</h1>
          {res ? res.content.map((obj, idx) => <Card login={obj.login} name={obj.name} key={idx}></Card>) :
            err ? <FetchError></FetchError> : <div>Loading 👽</div>}
          <button className="App-button">Кнопка</button>
        </header>
      </div>
    );
  }