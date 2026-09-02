interface Simpson {
    id: number;
    age: number;
    birthdate: string;
    gender: string;
    name: string;
    occupation: string;
    portraith_path: string;
    phrases: string[];
    status: string;
}

interface RespuestaApi {
  count: number;
  next: string | null;
  prev: string | null;
  pages: number;
  results: Simpson[];
}