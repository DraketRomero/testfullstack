import { IPersona } from "./IPersona";

export interface IRespuesta {
    status: boolean;
    msg: string;
    data: IPersona[] | IPersona | null
}