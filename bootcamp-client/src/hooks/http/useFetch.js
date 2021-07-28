import { useEffect, useState } from "react"

export const useFetch = (url, options, callback = null) => {
    const [res, setResponse] = useState(null);
    const [err, setError] = useState(null);

    useEffect(() => {
        const fetchData = async () => {
            try {
              const res = await fetch(url, options);
              const json = await res.json();
              setResponse(json);
              console.log(json); //debug
              if(typeof callback === 'function'){
                callback(json);
              }
              console.log("useFetch"); //debug
            } catch (error) {
              setError(error);
              console.log(error); //debug
            }
          };
        fetchData();
    }, []);

    return {res, err};
}