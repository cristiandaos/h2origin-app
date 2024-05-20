const LogIn = () => {
  return (
    <section className="bg-white">
      <div className="flex justify-center min-h-screen ">
        <div className="flex items-center w-full max-w-3xl p-8 mx-auto lg:px-12 lg:w-3/5">
          <div className="w-full">
            <h1 className="text-5xl font-semibold tracking-wider text-gray-800 capitalize">
              ¡Bievenido devuelta!
            </h1>
            {/* FALTAN AGREGAR MÁS CAMBIOS */}
            <p className="mt-4 text-gray-500 text-lg">
              ¿Aún no tienes una cuenta?,{" "}
              <a href="#" className="text-blue-400 hover:text-blue-300">
                Registrarse
              </a>
            </p>

            <form className="grid grid-cols-1 gap-4 mt-8 md:grid-cols-2">
              <div>
                <label className="block mb-2 text-m text-gray-500 font-medium">
                  Correo electrónico
                </label>
                <input
                  type="email"
                  placeholder="usuario@ejemplo.com"
                  className="block w-full px-5 py-3 mt-2 text-gray-700 placeholder-blue-200 border-2 border-blue-400 bg-white rounded-full focus:border-blue-400 focus:ring-blue-400 focus:outline-none focus:ring focus:ring-opacity-40"
                />
              </div>
              <br />
              <div>
                <label className="block mb-2 text-m text-gray-500 font-medium">
                  Contraseña
                </label>
                <input
                  type="password"
                  placeholder="Ingresa tu contraseña"
                  className="block w-full px-5 py-3 mt-2 text-gray-700 placeholder-blue-200 border-2 border-blue-400 rounded-full  bg-white focus:border-blue-400  focus:ring-blue-400 focus:outline-none focus:ring focus:ring-opacity-40"
                />
              </div>
              <br />
          <div className="mb-6 flex items-center justify-between">
            <div className="mb-[0.125rem] block min-h-[1.5rem] ps-[1.5rem]">
              <input className="relative float-left -ms-[1.5rem] me-[6px] mt-[0.15rem] h-[1.125rem] w-[1.125rem] appearance-none rounded-[0.25rem] border-[0.125rem] border-solid border-secondary-500 outline-none before:pointer-events-none before:absolute before:h-[0.875rem] before:w-[0.875rem] before:scale-0 before:rounded-full before:bg-transparent before:opacity-0 before:shadow-checkbox before:shadow-transparent before:content-[''] checked:border-primary checked:bg-primary checked:before:opacity-[0.16] checked:after:absolute checked:after:-mt-px checked:after:ms-[0.25rem] checked:after:block checked:after:h-[0.8125rem] checked:after:w-[0.375rem] checked:after:rotate-45 checked:after:border-[0.125rem] checked:after:border-l-0 checked:after:border-t-0 checked:after:border-solid checked:after:border-white checked:after:bg-transparent checked:after:content-[''] hover:cursor-pointer hover:before:opacity-[0.04] hover:before:shadow-black/60 focus:shadow-none focus:transition-[border-color_0.2s] focus:before:scale-100 focus:before:opacity-[0.12] focus:before:shadow-black/60 focus:before:transition-[box-shadow_0.2s,transform_0.2s] focus:after:absolute focus:after:z-[1] focus:after:block focus:after:h-[0.875rem] focus:after:w-[0.875rem] focus:after:rounded-[0.125rem] focus:after:content-[''] checked:focus:before:scale-100 checked:focus:before:shadow-checkbox checked:focus:before:transition-[box-shadow_0.2s,transform_0.2s] checked:focus:after:-mt-px checked:focus:after:ms-[0.25rem] checked:focus:after:h-[0.8125rem] checked:focus:after:w-[0.375rem] checked:focus:after:rotate-45 checked:focus:after:rounded-none checked:focus:after:border-[0.125rem] checked:focus:after:border-l-0 checked:focus:after:border-t-0 checked:focus:after:border-solid checked:focus:after:border-white checked:focus:after:bg-transparent rtl:float-right dark:border-neutral-400 dark:checked:border-primary dark:checked:bg-primary" type="checkbox" value="" id="exampleCheck3" checked />
              <label className="inline-block ps-[0.15rem] hover:cursor-pointer">
                Remember me
                </label>
            </div>
            <a href="#" className="text-primary focus:outline-none dark:text-primary-400 text-blue-500 hover:text-blue-400">
                Forgot password?
            </a>
          </div>
              <br />
              <button className="flex items-center justify-between w-full px-6 py-3 tracking-wide text-white text-lg font-medium capitalize transition-colors duration-300 transform bg-blue-500 rounded-full hover:bg-blue-400 focus:outline-none focus:ring focus:ring-blue-300 focus:ring-opacity-50">
                <span>Iniciar sesión </span>

                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  className="w-5 h-5 rtl:-scale-x-100"
                  viewBox="0 0 20 20"
                  fill="currentColor"
                >
                  <path
                    fill-rule="evenodd"
                    d="M7.293 14.707a1 1 0 010-1.414L10.586 10 7.293 6.707a1 1 0 011.414-1.414l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414 0z"
                    clip-rule="evenodd"
                  />
                </svg>
              </button>
              <br />
              <div
            className="my-4 flex items-center before:mt-0.5 before:flex-1 before:border-t before:border-neutral-300 after:mt-0.5 after:flex-1 after:border-t after:border-neutral-300 ">
            <p
              className="mx-4 mb-0 text-center font-semibold text-neutral-500">
              CONTINUAR MEDIANTE
            </p>
          </div>
            </form>
          </div>
        </div>
        <div className="hidden bg-cover lg:block lg:w-2/5"></div>
      </div>
    </section>
  );
};

export default LogIn;
