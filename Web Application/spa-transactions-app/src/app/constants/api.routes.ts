const API_ROUTES = {
    TRANSACTIONS: {
        GET_BY_CODE_AND_TYPE_PERSON: (code: string, type : string) => `/transactions/${code}/${type}/by-code-and-type-person`
    }
}

export default API_ROUTES;