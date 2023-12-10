const API_ROUTES = {
    TRANSACTIONS: {
        GET_BY_CODE_AND_TYPE_PERSON: (code: string, type : string) => `/transactions/${code}/${type}/by-code-and-type-person`
    },
    AUTH: {
        LOGIN: '/v1.0.0/auth/login'
    }
}

export default API_ROUTES;