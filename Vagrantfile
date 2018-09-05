Vagrant.configure(2) do |config|
  config.vm.box = "terrywang/archlinux"
  
  config.vm.provider "virtualbox" do |v|
    v.name = "java_marcelus_app"
  end

  #config.vm.network "forwarded_port", guest: 5000, host: 5000

  config.vm.network "forwarded_port", guest: 5005, host: 5005 # For debug

  config.vm.network "forwarded_port", guest: 8080, host: 8080 # For application

  # Mapping a directory outside the vm
  # config.vm.synced_folder "~/myApps/vagrantApps/java/java_marcelus", "/vagrant_data"

  # Setting ram ammount and cpu number
  config.vm.provider "virtualbox" do |v|
    v.memory = 768
    v.cpus = 4
  end

  config.vm.provision "shell", path: "vagrant_provision.sh", privileged: false
end