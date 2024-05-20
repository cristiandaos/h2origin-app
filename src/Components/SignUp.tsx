
const SignUp = () => {
    return (
<section className="bg-white">
    <div className="flex justify-center min-h-screen">
        <div className="hidden bg-cover lg:block lg:w-2/5">
        </div>

        <div className="flex items-center w-full max-w-3xl p-8 mx-auto lg:px-12 lg:w-3/5">
            <div className="w-full">
                <h1 className="text-4xl font-semibold tracking-wider text-gray-800">
                    ¡Regístrate, cambia el mundo!
                </h1>

                <p className="mt-4 text-gray-500 text-lg">
                    ¿Ya tienes una cuenta?, <a href="#" className="text-blue-400 hover:text-blue-300">Inicia sesión</a>
                </p>


                <form className="grid grid-cols-1 gap-6 mt-8 md:grid-cols-2">
                    <div>
                        <label className="block mb-2 text-m text-gray-500 font-medium">Nombres</label>
                        <input type="text" placeholder="John" className="block w-full px-5 py-3 mt-2 text-gray-700 placeholder-blue-200 border-2 border-blue-400 rounded-full bg-white focus:border-blue-400 focus:ring-blue-400 focus:outline-none focus:ring focus:ring-opacity-40" />
                    </div>

                    <div>
                        <label className="block mb-2 text-m text-gray-500 font-medium">Apellidos</label>
                        <input type="text" placeholder="Snow" className="block w-full px-5 py-3 mt-2 text-blue-400 placeholder-blue-200 border-2 border-blue-400 rounded-full bg-white focus:border-blue-400 focus:ring-blue-400 focus:outline-none focus:ring focus:ring-opacity-40" />
                    </div>

                    <div>
                        <label className="block mb-2 text-m text-gray-500 font-medium">Celular</label>
                        <input type="text" placeholder="999-999-999" className="block w-full px-5 py-3 mt-2 text-gray-700 placeholder-blue-200 border-2 border-blue-400 rounded-full bg-white focus:border-blue-400 focus:ring-blue-400 focus:outline-none focus:ring focus:ring-opacity-40" />
                    </div>

                    <div>
                        <label className="block mb-2 text-m text-gray-500 font-medium">Correo electrónico</label>
                        <input type="email" placeholder="usuario@ejemplo.com" className="block w-full px-5 py-3 mt-2 text-gray-700 placeholder-blue-200 border-2 border-blue-400 bg-white rounded-full focus:border-blue-400 focus:ring-blue-400 focus:outline-none focus:ring focus:ring-opacity-40" />
                    </div>

                    <div>
                        <label className="block mb-2 text-m text-gray-500 font-medium">Edad</label>
                        <input type="email" placeholder="20" className="block w-full px-5 py-3 mt-2 text-gray-700 placeholder-blue-200 border-2 border-blue-400 bg-white rounded-full focus:border-blue-400 focus:ring-blue-400 focus:outline-none focus:ring focus:ring-opacity-40" />
                    </div>

                    <div>
                        <label className="block mb-2 text-m text-gray-500 font-medium">Género</label>
                        <input type="number" placeholder="Selecciona tu género" className="block w-full px-5 py-3 mt-2 text-gray-700 placeholder-blue-200 border-2 border-blue-400 bg-white rounded-full focus:border-blue-400 focus:ring-blue-400 focus:outline-none focus:ring focus:ring-opacity-40" />
                    </div>

                    <div>
                        <label className="block mb-2 text-m text-gray-500 font-medium">Contraseña</label>
                        <input type="password" placeholder="Ingresa tu contraseña" className="block w-full px-5 py-3 mt-2 text-gray-700 placeholder-blue-200 border-2 border-blue-400 rounded-full  bg-white focus:border-blue-400  focus:ring-blue-400 focus:outline-none focus:ring focus:ring-opacity-40" />
                    </div>

                    <div>
                        <label className="block mb-2 text-m text-gray-500 font-medium">Confirma tu contraseña</label>
                        <input type="password" placeholder="Ingresa tu contraseña" className="block w-full px-5 py-3 mt-2 text-gray-700  border-2 border-blue-400 rounded-full placeholder-blue-200 bg-white  focus:border-blue-400 focus:ring-blue-400 focus:outline-none focus:ring focus:ring-opacity-40" />
                    </div>

                    <button
                        className="flex items-center justify-between w-full px-6 py-3 tracking-wide text-white text-lg font-medium capitalize transition-colors duration-300 transform bg-blue-500 rounded-full hover:bg-blue-400 focus:outline-none focus:ring focus:ring-blue-300 focus:ring-opacity-50">
                        <span>Crear cuenta </span>

                        <svg xmlns="http://www.w3.org/2000/svg" className="w-5 h-5 rtl:-scale-x-100" viewBox="0 0 20 20" fill="currentColor">
                            <path fill-rule="evenodd"
                                d="M7.293 14.707a1 1 0 010-1.414L10.586 10 7.293 6.707a1 1 0 011.414-1.414l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414 0z"
                                clip-rule="evenodd" />
                        </svg>
                    </button>
                </form>
            </div>
        </div>
    </div>
</section>        
    );
};

export default SignUp;