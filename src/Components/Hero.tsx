const Hero = () => {
  return (
    <div className="relative h-screen text-white overflow-hidden">
      <div className="absolute inset-0">
        <img
          src="https://cdn.pixabay.com/photo/2017/06/20/16/39/jungle-2423689_1280.jpg"
          alt="bg_origin"
          className="object-cover object-center w-full h-full"
        />
        <div className="absolute inset-0 bg-black opacity-60"></div>
      </div>

      <div className="relative z-10 flex flex-col justify-center items-center h-full text-center mx-auto max-w-7xl">
        <h1 className="text-5xl font-bold leading-tight mb-4">
          BIENVENIDOS AL ORIGEN DEL AGUA
        </h1>
        <p className="text-xl text-gray-200 mb-8 ">
          En un mundo donde el agua es cada vez más preciosa y su gestión más
          desafiante, H2ORIGIN surge como un faro de esperanza, proveyendo
          herramientas, datos, y una comunidad activa dedicada a asegurar un
          futuro hídrico sostenible para todos.
        </p>
        <a
          href="#"
          className="bg-blue-600 text-white hover:bg-blue-800 py-2 px-6 rounded-full text-lg font-medium transition duration-300 ease-in-out transform hover:scale-105 hover:shadow-lg"
        >
          Inicia con el cambio
        </a>
      </div>
    </div>
  );
};

export default Hero;
