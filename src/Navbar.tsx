import { Bars3BottomLeftIcon, XMarkIcon } from "@heroicons/react/24/solid";
import { useState } from "react";

const Navbar = () => {
  const Links = [
    { name: "Inicio", link: "/" },
    { name: "Ayuda", link: "/" },
    { name: "Contacto", link: "/" },
    { name: "Lenguaje", link: "/" },
  ];

  const [isOpen, setisOpen] = useState(false);

  return (
    <div className="relative shadow-md w-full top-0 left-0">
      <div className="md:px-10 py-4 px-7 md:flex justify-between items-center bg-white">
        {/* Logo */}
        <div className="flex cursor-pointer items-center gap-2">
          <img src="/src/assets/logo.svg" alt="logo_h2origin" />
        </div>
        {/* Menu icon */}
        <div
          onClick={() => setisOpen(!isOpen)}
          className="w-9 h-9 absolute right-4 top-7 cursor-pointer md:hidden"
        >
          {isOpen ? <XMarkIcon /> : <Bars3BottomLeftIcon />}
        </div>
        {/* Nav Links */}
        <ul
          className={`md:flex md:items-center md:pb-0 pb-12 absolute md:static bg-white md:z-auto z-[-1] left-0 w-full md:w-auto md:pl-0 pl-9 transition-all duration-700 ease-in ${isOpen ? 'top-16' : 'top-[-490px]'}
`}
        >
          {Links.map((link) => (
            <li className="font-medium my-7 md:my-0 md:ml-8">
              <a
                href={link.link}
                className="text-gray-500 hover:text-blue-600 transition duration-700 ease-in-out hover:underline hover:underline-offset-8 hover:decoration-blue-700 hover:decoration-2 hover:decoration-thick"
              >
                {link.name}
              </a>
            </li>
          ))}
          <a href="./Components/LogIn.tsx">
          <button className="btn bg-blue-600 text-white py-2 px-4 md:ml-8 rounded-full md:static transition duration-700 ease-in-out hover:bg-blue-800 hover:shadow-lg">
            Registrar
          </button>
          </a>
          <a href="./Components/SignUp.tsx">
          <button className="btn bg-blue-600 text-white py-2 px-4 ml-2 md:mt-0 rounded-full md:static transition duration-700 ease-in-out hover:bg-blue-800 hover:shadow-lg">
            Iniciar sesión
          </button>
          </a>
        </ul>
      </div>
    </div>
  );
};

export default Navbar;
