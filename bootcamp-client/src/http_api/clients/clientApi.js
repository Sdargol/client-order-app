const host = 'http://localhost:8080/';

export const createClient = (client) => {
    fetch(host + 'api/v1/clients',
    {
      method: "POST",
      headers: { 'Content-Type': 'application/json;charset=utf-8' },
      body: JSON.stringify(client)
    })
    .then(response => response.json())
    .then(data => {
      console.log(data);
    })
    .catch(e => console.log(e));
}

export const getAllClients = () => {
    fetch(host + 'api/v1/clients',
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

export const updateClient = (client) => {
    fetch(host + 'api/v1/clients',
    {
      method: "PUT",
      headers: { 'Content-Type': 'application/json;charset=utf-8' },
      body: JSON.stringify(client)
    })
    .then(response => response.json())
    .then(data => {
      console.log(data);
    })
    .catch(e => console.log(e));
}

export const deleteClientByLogin = (login) => {
    fetch(host + `api/v1/clients/${login}`,
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

export const getClientByLogin = (login) => {
    fetch(host + `api/v1/clients/${login}`,
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