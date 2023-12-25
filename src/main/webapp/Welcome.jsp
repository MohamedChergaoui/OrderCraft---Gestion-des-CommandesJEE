<%@ page import="java.util.List" %>
<%@ page import="com.example.apprendejee.Model.Commande" %>
<%@ page import="com.example.apprendejee.DAO.Clien.IClient" %>
<%@ page import="com.example.apprendejee.DAO.Clien.ClientImpl" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<html>
<head>
    <title>Title</title>
    <link href="https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css" rel="stylesheet">
    <script src="js/Login.js"></script>

    <%
        List<Commande> commandes=new ArrayList<>();
        List<Integer> CommandeSelcted=new ArrayList<>();
        IClient MetierClient= new ClientImpl();
        String name="";
        String role="";
        if(session.getAttribute("role")!=null && session.getAttribute("name").toString()!=null){
            name = session.getAttribute("name").toString();
            role = session.getAttribute("role").toString();
             commandes = (List<Commande>) session.getAttribute("Commandes");
            CommandeSelcted= (List<Integer>) session.getAttribute("CommandeSelcted");


        }
        else{
      %>


    <%
            response.sendRedirect("Login.jsp");
        }
    %>


</head>
<body>


    <!-- This example requires Tailwind CSS v2.0+ -->
    <!--
      This example requires updating your template:

      ```
      <html class="h-full bg-white">
      <body class="h-full overflow-hidden">
      ```
    -->
    <div class="h-full flex">
        <!-- Off-canvas menu for mobile, show/hide based on off-canvas menu state. -->
        <div class="fixed inset-0 flex z-40 lg:hidden" role="dialog" aria-modal="true">

            <div class="fixed inset-0 bg-gray-600 bg-opacity-75" aria-hidden="true"></div>


            <div class="relative flex-1 flex flex-col max-w-xs w-full bg-white focus:outline-none">

                <div class="flex-shrink-0 flex border-t border-gray-200 p-4">
                    <a href="#" class="flex-shrink-0 group block">
                        <div class="flex items-center">
                            <div>
                                <img class="inline-block h-10 w-10 rounded-full" src="https://images.unsplash.com/photo-1517365830460-955ce3ccd263?ixlib=rb-=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=8&w=256&h=256&q=80" alt="">
                            </div>
                            <div class="ml-3">
                                <p class="text-base font-medium text-gray-700 group-hover:text-gray-900"><%=name%></p>
                                <p class="text-sm font-medium text-gray-500 group-hover:text-gray-700">View profile</p>
                            </div>
                        </div>
                    </a>
                </div>
            </div>

            <div class="flex-shrink-0 w-14" aria-hidden="true">
                <!-- Force sidebar to shrink to fit close icon -->
            </div>
        </div>

        <!-- Static sidebar for desktop -->
        <div class="hidden lg:flex lg:flex-shrink-0">
            <div class="flex flex-col w-64">
                <!-- Sidebar component, swap this element with another sidebar if you like -->
                <div class="flex-1 flex flex-col min-h-0 border-r border-gray-200 bg-gray-100">
                    <div class="flex-1 flex flex-col pt-5 pb-4 overflow-y-auto">
                        <div class="flex items-center flex-shrink-0 px-4">
                            <img class="h-8 w-auto" src="https://tailwindui.com/img/logos/workflow-logo-indigo-600-mark-gray-900-text.svg" alt="Workflow">
                        </div>
                        <nav class="mt-5 flex-1" aria-label="Sidebar">
                            <div class="px-2 space-y-1">
                                <!-- Current: "bg-gray-200 text-gray-900", Default: "text-gray-600 hover:bg-gray-50 hover:text-gray-900" -->
                                <a href="Welcome.jsp" class="bg-gray-200 text-gray-900 group flex items-center px-2 py-2 text-sm font-medium rounded-md">
                                    <svg class="text-gray-500 mr-3 h-6 w-6" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" width="21" height="20" fill="none" viewBox="0 0 21 20">
                                        <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M3.308 9a2.257 2.257 0 0 0 2.25-2.264 2.25 2.25 0 0 0 4.5 0 2.25 2.25 0 0 0 4.5 0 2.25 2.25 0 1 0 4.5 0C19.058 5.471 16.956 1 16.956 1H3.045S1.058 5.654 1.058 6.736A2.373 2.373 0 0 0 3.308 9Zm0 0a2.243 2.243 0 0 0 1.866-1h.767a2.242 2.242 0 0 0 3.733 0h.767a2.242 2.242 0 0 0 3.733 0h.767a2.247 2.247 0 0 0 1.867 1A2.22 2.22 0 0 0 18 8.649V19H9v-7H5v7H2V8.524c.37.301.83.469 1.308.476ZM12 12h3v3h-3v-3Z"/>
                                    </svg>
                                    Commandes
                                </a>
                                <a href="Product.Product" class="text-gray-600 hover:bg-gray-50 hover:text-gray-900 group flex items-center px-2 py-2 text-sm font-medium rounded-md">

                                    <svg class="text-gray-500 mr-3 h-6 w-6" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" width="21" height="20" fill="none" viewBox="0 0 21 20">
                                        <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M3.308 9a2.257 2.257 0 0 0 2.25-2.264 2.25 2.25 0 0 0 4.5 0 2.25 2.25 0 0 0 4.5 0 2.25 2.25 0 1 0 4.5 0C19.058 5.471 16.956 1 16.956 1H3.045S1.058 5.654 1.058 6.736A2.373 2.373 0 0 0 3.308 9Zm0 0a2.243 2.243 0 0 0 1.866-1h.767a2.242 2.242 0 0 0 3.733 0h.767a2.242 2.242 0 0 0 3.733 0h.767a2.247 2.247 0 0 0 1.867 1A2.22 2.22 0 0 0 18 8.649V19H9v-7H5v7H2V8.524c.37.301.83.469 1.308.476ZM12 12h3v3h-3v-3Z"/>
                                    </svg>

                                    Product
                                </a>
                                <%  if (role.equals("admin")){%>

                                <a href="user.java" class="text-gray-600 hover:bg-gray-50 hover:text-gray-900 group flex items-center px-2 py-2 text-sm font-medium rounded-md">
                                    <!-- Heroicon name: outline/user-group -->
                                    <svg class="text-gray-400 group-hover:text-gray-500 mr-3 h-6 w-6" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" aria-hidden="true">
                                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M17 20h5v-2a3 3 0 00-5.356-1.857M17 20H7m10 0v-2c0-.656-.126-1.283-.356-1.857M7 20H2v-2a3 3 0 015.356-1.857M7 20v-2c0-.656.126-1.283.356-1.857m0 0a5.002 5.002 0 019.288 0M15 7a3 3 0 11-6 0 3 3 0 016 0zm6 3a2 2 0 11-4 0 2 2 0 014 0zM7 10a2 2 0 11-4 0 2 2 0 014 0z" />
                                    </svg>
                                    Users
                                </a>
                                <%}%>
                                <a href="Clients.Client" class="text-gray-600 hover:bg-gray-50 hover:text-gray-900 group flex items-center px-2 py-2 text-sm font-medium rounded-md">
                                    <!-- Heroicon name: outline/search-circle -->

                                    <svg class="text-gray-400 group-hover:text-gray-500 mr-3 h-6 w-6" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 20">
                                        <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4.333 6.764a3 3 0 1 1 3.141-5.023M2.5 16H1v-2a4 4 0 0 1 4-4m7.379-8.121a3 3 0 1 1 2.976 5M15 10a4 4 0 0 1 4 4v2h-1.761M13 7a3 3 0 1 1-6 0 3 3 0 0 1 6 0Zm-4 6h2a4 4 0 0 1 4 4v2H5v-2a4 4 0 0 1 4-4Z"/>
                                    </svg>
                                    Clients
                                </a>

                                <a href="logout.do" class="text-gray-600 hover:bg-gray-50 hover:text-gray-900 group flex items-center px-2 py-2 text-sm font-medium rounded-md">
                                    <!-- Heroicon name: outline/speakerphone -->
                                    <svg class=" text-gray-400 dark:text-white mr-3 h-6 w-6" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 16 16">
                                        <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 8h11m0 0-4-4m4 4-4 4m-5 3H3a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h3"/>
                                    </svg>
                                    Logout
                                </a>


                            </div>
                        </nav>
                    </div>
                    <div class="flex-shrink-0 flex border-t border-gray-200 p-4">
                        <a href="#" class="flex-shrink-0 w-full group block">
                            <div class="flex items-center">

                                    <img class="inline-block h-1/6 w-1/6 rounded-full" src="https://images.unsplash.com/photo-1517365830460-955ce3ccd263?ixlib=rb-=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=8&w=256&h=256&q=80" alt="">

                                <div class="ml-3">
                                    <p class="text-sm font-medium text-gray-700 group-hover:text-gray-900"><%=name %>/p>
                                    <p class="text-xs font-medium text-gray-500 group-hover:text-gray-700">View profile</p>
                                </div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <div class="flex flex-col min-w-0 flex-1 overflow-hidden">
            <div class="lg:hidden">
                <div class="flex items-center justify-between bg-gray-50 border-b border-gray-200 px-4 py-1.5">
                    <div>
                        <img class="h-8 w-auto" src="https://tailwindui.com/img/logos/workflow-mark-indigo-600.svg" alt="Workflow">
                    </div>
                    <div>
                        <button type="button" class="-mr-3 h-12 w-12 inline-flex items-center justify-center rounded-md text-gray-500 hover:text-gray-900">
                            <span class="sr-only">Open sidebar</span>
                            <!-- Heroicon name: outline/menu -->
                            <svg class="h-6 w-6" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" aria-hidden="true">
                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 12h16M4 18h16" />
                            </svg>
                        </button>
                    </div>
                </div>
            </div>
            <div class="flex-1 relative z-0 flex overflow-hidden">
                <main class="flex-1 relative z-0 overflow-y-auto focus:outline-none">
                    <!-- Start main area-->
                    <div class="absolute inset-0 py-6 px-4 sm:px-6 lg:px-8">
                        <div class="h-full ">
                            <div class="px-4 sm:px-6 lg:px-8">
                                <div class="sm:flex sm:items-center">
                                    <div class="sm:flex-auto">
                                        <h1 class="text-xl font-semibold text-gray-900">Commandes</h1>
                                        <p class="mt-2 text-sm text-gray-700">A list of all the Commandes in your account including their id_commande, client, Date de commande and Amount</p>
                                    </div>
                                    <div class="mt-4 sm:mt-0 sm:ml-16 sm:flex-none">
                                        <a href="AddCommande.jsp" class="inline-flex items-center justify-center rounded-md border border-transparent bg-indigo-600 px-4 py-2 text-sm font-medium text-white shadow-sm hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-offset-2 sm:w-auto">Add Product</a>
                                    </div>
                                </div>
                                <div class="mt-8 flex flex-col">
                                    <div class="-my-2 -mx-4 overflow-x-auto sm:-mx-6 lg:-mx-8">
                                        <div class="inline-block min-w-full py-2 align-middle md:px-6 lg:px-8">
                                            <div class="overflow-hidden shadow ring-1 ring-black ring md:rounded-lg">
                                                <table class="min-w-full divide-y divide-gray-500">
                                                    <thead class="bg-gray-50">
                                                    <tr>
                                                        <th scope="col" class="py-3.5 pl-4 pr-3 text-left text-sm font-semibold text-gray-900 sm:pl-6">Id</th>
                                                        <th scope="col" class="py-3.5 pl-4 pr-3 text-left text-sm font-semibold text-gray-900 sm:pl-6">Client</th>
                                                        <th scope="col" class="px-3 py-3.5 text-left text-sm font-semibold text-gray-900">Date</th>
                                                        <th scope="col" class="px-3 py-3.5 text-left text-sm font-semibold text-gray-900">Amount</th>
                                                        <th scope="col" class="px-3 py-3.5 text-left text-sm font-semibold text-gray-900">Status</th>
                                                        <th scope="col" class="relative py-3.5 pl-3 pr-4 sm:pr-6">
                                                            <span class="sr-only">Edit</span>
                                                        </th>
                                                    </tr>
                                                    </thead>
                                                    <tbody class="divide-y divide-gray-600 bg-white">


                                                    <%for (Commande commande : commandes) {%>
                                                    <tr>
                                                        <td class="whitespace-nowrap py-4 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-6"><%= commande.getId() %></td>
                                                        <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500"><%=MetierClient.GetClientById(commande.getId_client()).getName() %></td>
                                                        <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500"><%=commande.getOrder_date() %></td>
                                                        <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500"><%=commande.getAmount() %></td>
                                                        <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500"><%=commande.getSatusCommande().toString() %></td>

                                                        <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500">
                                                            <a href="EditCommande.Commande?id=<%=commande.getId()%>" >
                                                                <button type="button" class="inline-flex items-center justify-center rounded-md border border-transparent bg-indigo-600 px-4 py-2 text-sm font-medium text-white shadow-sm hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-offset-2 sm:w-auto">
                                                                    Show
                                                                </button>
                                                                <span class="sr-only">, Lindsay Walton</span></a>
                                                            <%
                                                                if(!CommandeSelcted.contains( commande.getId())){
                                                            %>
                                                            <a href="SelectProduct.Commande?id=<%=commande.getId()%>" >
                                                                <button type="button" class="inline-flex items-center justify-center rounded-md border border-transparent bg-indigo-600 px-4 py-2 text-sm font-medium text-white shadow-sm hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-offset-2 sm:w-auto">
                                                                    Select Product
                                                                </button>
                                                                <span class="sr-only">, Lindsay Walton</span></a>
                                                            <%}%>


                                                        </td>

                                                    </tr>
                                                    <% }%>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- End main area -->
                </main>
                <aside class=" relative xl:flex xl:flex-col flex-shrink-0 w-96 border-l border-gray-200 overflow-y-auto">
                    <!-- Start secondary column (hidden on smaller screens) -->

                    <!-- End secondary column -->
                </aside>
            </div>
        </div>
    </div>

</body>
</html>
