const host = 'http://localhost:8080/';

export const createOrder = (order) => {
    fetch(host + 'api/v1/orders',
    {
      method: "POST",
      headers: { 'Content-Type': 'application/json;charset=utf-8' },
      body: JSON.stringify(order)
    })
    .then(response => response.json())
    .then(data => {
      console.log(data);
    })
    .catch(e => console.log(e));
}

export const getAllOrders = () => {
    fetch(host + 'api/v1/orders',
    {
      method: "GET",
      headers: { 'Content-Type': 'application/json;charset=utf-8' },
    })
    .then(response => response.json())
    .then(data => {
      console.log(data);
    })
    .catch(e => console.log(e));
}

export const getOrderById = (id) => {
    fetch(host + `api/v1/orders/${id}`,
    {
      method: "GET",
      headers: { 'Content-Type': 'application/json;charset=utf-8' },
    })
    .then(response => response.json())
    .then(data => {
      console.log(data);
    })
    .catch(e => console.log(e));
}

export const updateOrder = (order) => {
    fetch(host + 'api/v1/orders',
    {
      method: "PUT",
      headers: { 'Content-Type': 'application/json;charset=utf-8' },
      body: JSON.stringify(order)
    })
    .then(response => response.json())
    .then(data => {
      console.log(data);
    })
    .catch(e => console.log(e));
}

export const deleteOrder = (id) => {
    fetch(host + `api/v1/orders/${id}`,
    {
      method: "DELETE",
      headers: { 'Content-Type': 'application/json;charset=utf-8' },
    })
    .then(response => response.json())
    .then(data => {
      console.log(data);
    })
    .catch(e => console.log(e));
}

