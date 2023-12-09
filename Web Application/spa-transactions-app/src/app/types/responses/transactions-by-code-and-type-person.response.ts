export interface Header {
    name: string
    lastname: string
    age: number
    workPosition: string
}

export interface Payload {
    bankAccount: string
    creationDateAccount: string
    transactions: Transaction[]
}

export interface Transaction {
    numTrx: number
    bankAccountOrigin: string
    bankAccountDestiny: string
    description: string
    date: string
    amount: number
    iva: number
    commission: number
    type: string
}


export interface ITransactionsByCodeAndTypeResponse {
    header: Header
    payload: Payload[]
}